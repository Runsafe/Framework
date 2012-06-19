package no.runsafe.framework;

import no.runsafe.framework.command.ICommand;
import no.runsafe.framework.command.RunsafeCommandHandler;
import no.runsafe.framework.configuration.IConfiguration;
import no.runsafe.framework.configuration.IConfigurationFile;
import no.runsafe.framework.configuration.RunsafeConfigurationHandler;
import no.runsafe.framework.database.DatabaseHelper;
import no.runsafe.framework.database.RunsafeDatabaseHandler;
import no.runsafe.framework.event.*;
import no.runsafe.framework.messaging.*;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.output.RunsafeOutputHandler;
import no.runsafe.framework.plugin.PluginResolver;
import no.runsafe.framework.server.RunsafeServer;
import no.runsafe.framework.timer.Scheduler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.behaviors.Caching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

public abstract class RunsafePlugin extends JavaPlugin implements IKernel
{
	public static IKernel getPluginKernel()
	{
		return kernel;
	}

	public RunsafePlugin()
	{
		super();
		kernel = this;
	}

	@Override
	public void onEnable()
	{
		if (container == null)
		{
			container = new DefaultPicoContainer(new Caching());
			this.container.addComponent(this);

            //REMOVE THIS ONCE ALL MOVE TO RUNSAFE SERVER
			this.container.addComponent(this.getServer());
            this.container.addComponent(new RunsafeServer(this.getServer()));

			this.container.addComponent(this.getLogger());
			this.container.addComponent(RunsafeConfigurationHandler.class);
			this.container.addComponent(RunsafeOutputHandler.class);
			this.container.addComponent(RunsafeDatabaseHandler.class);
			this.container.addComponent(Scheduler.class);
			this.container.addComponent(DatabaseHelper.class);
			this.container.addComponent(PlayerStatus.class);
			this.container.addComponent(PluginResolver.class);
			output = getComponent(IOutput.class);

			if(this instanceof IConfigurationFile)
				getComponent(IConfiguration.class).setConfigFileProvider((IConfigurationFile)this);

			IMessagePump pump = null;
			if (!(this instanceof IPumpProvider))
			{
				pump = MessagePump.GetPump(this);
				if (pump != null)
					addComponent(pump);
			}

			this.PluginSetup();

			if (pump != null)
			{
				List<IMessageBusService> services = getComponents(IMessageBusService.class);
				if (services != null)
					for (IMessageBusService svc : services)
					{
						output.outputDebugToConsole(String.format("Registering %s message bus service in %s", svc.getServiceName(), svc.getClass().getName()), Level.INFO);
						pump.RegisterService(svc);
					}
			}

			output.outputDebugToConsole(String.format("Initiating plugin %s", this.getName()), Level.FINE);
			RegisterEvents();
			RegisterCommands();
			output.outputDebugToConsole(String.format("Registered %d event listeners", eventListeners.size()), Level.FINE);
			output.outputDebugToConsole(String.format("Initiation of %s completed", this.getName()), Level.FINE);
		}

		for (IPluginEnabled impl : getComponents(IPluginEnabled.class))
		{
			impl.OnPluginEnabled();
		}
	}

	@Override
	public void onDisable()
	{
		output.outputDebugToConsole(String.format("Disabling plugin %s", this.getName()), Level.FINE);

		IMessagePump pump = MessagePump.GetPump(this);
		if (pump != null)
		{
			List<IMessageBusService> services = getComponents(IMessageBusService.class);
			if (services != null)
				for (IMessageBusService svc : services)
				{
					output.outputDebugToConsole(String.format("UnRegistering %s message bus service in %s", svc.getServiceName(), svc.getClass().getName()), Level.INFO);
					pump.UnregisterService(svc);
				}
		}

		for (IPluginDisabled impl : getComponents(IPluginDisabled.class))
		{
			impl.OnPluginDisabled();
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		String command = cmd.getName().toLowerCase();
		return commands.containsKey(command) && commands.get(command).onCommand(sender, cmd, label, args);
	}

	@Override
	public void addComponent(Object implOrInstance)
	{
		output.outputDebugToConsole(String.format("Plugin %s added component %s", this.getName(), implOrInstance.getClass().getCanonicalName()), Level.FINE);
		container.addComponent(implOrInstance);
	}

	@Override
	public <T> T getComponent(Class<T> type)
	{
		return this.container.getComponent(type);
	}

	@Override
	public <T> T getInstance(Class<T> type)
	{
		container.addComponent(type);
		T instance = container.getComponent(type);
		container.removeComponent(type);
		return instance;
	}

	@Override
	public <T> List<T> getComponents(Class<T> type)
	{
		return this.container.getComponents(type);
	}

	protected List<Listener> GetEvents()
	{
		return getComponents(Listener.class);
	}

	protected List<RunsafeCommandHandler> GetCommands()
	{
		ArrayList<RunsafeCommandHandler> handlers = new ArrayList<RunsafeCommandHandler>();
		for(ICommand command : getComponents(ICommand.class))
			handlers.add(new RunsafeCommandHandler(command));

		return handlers;
	}

	protected abstract void PluginSetup();

	private void RegisterEvents()
	{
		PluginManager pluginManager = this.getServer().getPluginManager();

		EventEngine engine = new EventEngine(container.getComponents(IRunsafeEvent.class));
		for (Listener listener : engine.getListeners())
		{
			pluginManager.registerEvents(listener, this);
			output.outputDebugToConsole(String.format("Registered event listener %s", listener.getClass().getName()), Level.FINER);
		}

		eventListeners = GetEvents();
		if (eventListeners != null && !eventListeners.isEmpty())
		{
			for (Listener listener : eventListeners)
			{
				pluginManager.registerEvents(listener, this);
				output.outputDebugToConsole(String.format("Registered event listener %s", listener.getClass().getName()), Level.FINER);
			}
		}

		List<IConfigurationChanged> configListeners = getComponents(IConfigurationChanged.class);
		if(configListeners != null && configListeners.size() > 0)
			getComponent(IConfiguration.class).setListeners(configListeners);
	}

	private void RegisterCommands()
	{
		commands = new HashMap<String, RunsafeCommandHandler>();
		List<RunsafeCommandHandler> commandList = this.GetCommands();
		for (RunsafeCommandHandler handler : commandList)
		{
			PluginCommand command = getCommand(handler.getName());

			if (command == null)
				output.outputToConsole(String.format("Command not found: %s - does it exist in plugin.yml?", handler.getName()));
			else
				command.setExecutor(handler);
		}
	}

	protected DefaultPicoContainer container = null;
	private List<Listener> eventListeners;
	private IOutput output;
	private HashMap<String, RunsafeCommandHandler> commands;
	private static IKernel kernel;
}
