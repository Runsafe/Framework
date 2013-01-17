package no.runsafe.framework;

import no.runsafe.framework.command.BukkitCommandExecutor;
import no.runsafe.framework.command.ICommand;
import no.runsafe.framework.command.ICommandHandler;
import no.runsafe.framework.command.RunsafeCommandHandler;
import no.runsafe.framework.configuration.IConfiguration;
import no.runsafe.framework.configuration.IConfigurationFile;
import no.runsafe.framework.configuration.RunsafeConfigurationHandler;
import no.runsafe.framework.database.*;
import no.runsafe.framework.event.*;
import no.runsafe.framework.hook.*;
import no.runsafe.framework.messaging.*;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.output.RunsafeOutputHandler;
import no.runsafe.framework.plugin.IPluginUpdate;
import no.runsafe.framework.plugin.PluginResolver;
import no.runsafe.framework.server.ICommandExecutor;
import no.runsafe.framework.server.RunsafeConsole;
import no.runsafe.framework.server.RunsafeServer;
import no.runsafe.framework.server.player.RunsafePlayer;
import no.runsafe.framework.timer.IScheduler;
import no.runsafe.framework.timer.Scheduler;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.behaviors.Caching;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

public abstract class RunsafePlugin extends JavaPlugin implements IKernel
{
	public static final HashMap<String, RunsafePlugin> Instances = new HashMap<String, RunsafePlugin>();

	public static ICommandHandler getPluginCommand(String name)
	{
		for (String plugin : Instances.keySet())
		{
			PluginCommand command = Instances.get(plugin).getCommand(name);
			if (command != null)
			{
				CommandExecutor executor = command.getExecutor();
				if (executor instanceof BukkitCommandExecutor)
				{
					BukkitCommandExecutor handler = (BukkitCommandExecutor) executor;
					return handler.getHandler();
				}
			}
		}
		return null;
	}

	@Override
	public void onEnable()
	{
		if (container == null)
			initializePlugin();
		IOutput console = getComponent(IOutput.class);
		console.fine("Plugin initialized.");

		registerServices();
		console.fine("Plugin services registered.");
		addFrameworkHooks();
		console.fine("Plugin framework hooks added.");

		for (IPluginEnabled impl : getComponents(IPluginEnabled.class))
			impl.OnPluginEnabled();
		console.fine("Plugin enabled event executed.");

		logPluginVersion();
		console.fine("Plugin version logged.");
	}

	private void addFrameworkHooks()
	{
		addFrameworkHooks(IPlayerDataProvider.class, RunsafePlayer.dataHooks);
		addFrameworkHooks(IPlayerVisibility.class, RunsafePlayer.visibilityHooks);
		addFrameworkHooks(IPlayerPermissions.class, RunsafePlayer.permissionHooks);
		addFrameworkHooks(IPlayerLookupService.class, RunsafeServer.lookupHooks);
		addFrameworkHooks(IPlayerNameDecorator.class, RunsafePlayer.decoratorHooks);
		addFrameworkHooks(IPlayerBuildPermission.class, RunsafePlayer.buildPermissionHooks);
		addFrameworkHooks(IPlayerPvPFlag.class, RunsafePlayer.pvpFlagHooks);
	}

	private <T extends FrameworkHook> void addFrameworkHooks(Class<T> hook, List<T> storage)
	{
		List<T> hooks = getComponents(hook);
		if (hooks != null)
			storage.addAll(hooks);
	}

	@Override
	public void onDisable()
	{
		output.outputDebugToConsole(String.format("Disabling plugin %s", this.getName()), Level.FINE);

		unregisterServices();

		for (IPluginDisabled impl : getComponents(IPluginDisabled.class))
		{
			impl.OnPluginDisabled();
		}
	}

	@Override
	public void addComponent(Object implOrInstance)
	{
		output.outputDebugToConsole(
			String.format("Plugin %s added component %s",
				this.getName(),
				implOrInstance instanceof Class ? ((Class) implOrInstance).getCanonicalName() : implOrInstance.getClass().getCanonicalName()
			),
			Level.FINE
		);
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

	public String getLastVersion()
	{
		YamlConfiguration config = new YamlConfiguration();
		try
		{
			config.load("runsafe/plugins.yml");
		}
		catch (IOException e)
		{
			return null;
		}
		catch (InvalidConfigurationException e)
		{
			output.outputToConsole(String.format("Invalid yml in runsafe/plugins.yml! - %s", e.getMessage()), Level.WARNING);
			return null;
		}
		return config.getString(this.getName());
	}

	public void saveCurrentVersion()
	{
		YamlConfiguration config = new YamlConfiguration();
		try
		{
			config.load("runsafe/plugins.yml");
		}
		catch (IOException e)
		{
			output.outputToConsole(String.format("Problem loading runsafe/plugins.yml! - %s", e.getMessage()), Level.WARNING);
		}
		catch (InvalidConfigurationException e)
		{
			output.outputToConsole(String.format("Invalid yml in runsafe/plugins.yml! - %s", e.getMessage()), Level.WARNING);
		}
		config.set(getName(), getDescription().getVersion());
		try
		{
			config.save("runsafe/plugins.yml");
		}
		catch (IOException e)
		{
			output.outputToConsole(String.format("Unable to save runsafe/plugins.yml! - %s", e.getMessage()), Level.SEVERE);
		}
	}

	protected List<Listener> GetEvents()
	{
		return getComponents(Listener.class);
	}

	protected List<RunsafeCommandHandler> GetLegacyCommands()
	{
		ArrayList<RunsafeCommandHandler> handlers = new ArrayList<RunsafeCommandHandler>();
		for (ICommand command : getComponents(ICommand.class))
		{
			command.setConsole(output);
			handlers.add(new RunsafeCommandHandler(command, output));
		}
		return handlers;
	}

	protected List<BukkitCommandExecutor> GetCommands()
	{
		ICommandExecutor console = new RunsafeConsole(output);
		ArrayList<BukkitCommandExecutor> handlers = new ArrayList<BukkitCommandExecutor>();
		for (ICommandHandler command : getComponents(ICommandHandler.class))
		{
			command.setConsole(getComponent(IOutput.class));
			handlers.add(new BukkitCommandExecutor(command, console));
		}
		return handlers;
	}

	protected abstract void PluginSetup();

	private void initializePlugin()
	{
		if (RunsafeServer.Instance == null)
			RunsafeServer.Instance = new RunsafeServer(this.getServer());
		Instances.put(getName(), this);

		container = new DefaultPicoContainer(new Caching());
		addStandardComponents();

		output = getComponent(IOutput.class);
		output.outputDebugToConsole("Wiring up plugin", Level.FINE);

		// When the plugin has configuration, get it.
		if (this instanceof IConfigurationFile)
		{
			output.outputDebugToConsole("Loading configuration for plugin..", Level.FINE);
			getComponent(IConfiguration.class).setConfigFileProvider((IConfigurationFile) this);
		}

		// Initiate pump before plugin setup is done
		output.outputDebugToConsole("Initiating message pump", Level.FINE);
		getMessagePump();

		this.PluginSetup();

		RegisterEvents();
		RegisterCommands();
		executeSchemaUpdaters();
		executeSchemaChanges();
		output.outputDebugToConsole("Initiation complete", Level.FINE);
	}

	private void addStandardComponents()
	{
		this.container.addComponent(this);
		this.container.addComponent(new RunsafeServer(this.getServer()));
		this.container.addComponent(this.getLogger());
		this.container.addComponent(RunsafeConfigurationHandler.class);
		this.container.addComponent(RunsafeOutputHandler.class);
		this.container.addComponent(RunsafeDatabaseHandler.class);
		this.container.addComponent(new Scheduler(this.getServer().getScheduler(), this));
		this.container.addComponent(DatabaseHelper.class);
		this.container.addComponent(PlayerStatus.class);
		this.container.addComponent(new PluginResolver(this.getServer()));
		this.container.addComponent(SchemaRevisionRepository.class);
	}

	private void registerServices()
	{
		IMessagePump pump = getMessagePump();
		List<IMessageBusService> services = getComponents(IMessageBusService.class);
		if (services != null)
			for (IMessageBusService svc : services)
			{
				output.outputDebugToConsole(String.format("Registering %s message bus service in %s", svc.getServiceName(), svc.getClass().getName()), Level.INFO);
				pump.RegisterService(svc);
			}
	}

	private void logPluginVersion()
	{
		String lastVersion = getLastVersion();
		if (!getDescription().getVersion().equals(lastVersion))
		{
			IPluginUpdate updater = getComponent(IPluginUpdate.class);
			if (updater == null || updater.UpdateFrom(lastVersion))
				saveCurrentVersion();
		}
	}

	private IMessagePump getMessagePump()
	{
		IMessagePump pump;
		if (this instanceof IPumpProvider)
		{
			getComponent(IOutput.class).outputDebugToConsole("We are the pump..", Level.FINE);
			return ((IPumpProvider) this).getInstance();
		}

		pump = getComponent(IMessagePump.class);
		if (pump == null)
		{
			getComponent(IOutput.class).outputDebugToConsole("Looking for the pump..", Level.FINE);
			pump = MessagePump.GetPump();
			if (pump != null)
				addComponent(pump);
			else
				getComponent(IOutput.class).outputDebugToConsole("Pump not found!", Level.FINE);
		}
		return pump;
	}

	private void executeSchemaUpdaters()
	{
		List<ISchemaUpdater> updaters = getComponents(ISchemaUpdater.class);
		if (!updaters.isEmpty())
		{
			SchemaRevisionRepository repository = getComponent(SchemaRevisionRepository.class);
			IDatabase db = getComponent(IDatabase.class);
			for (ISchemaUpdater impl : updaters)
				impl.Run(repository, db);
		}
	}

	private void executeSchemaChanges()
	{
		List<ISchemaChanges> changeSets = getComponents(ISchemaChanges.class);
		if (!changeSets.isEmpty())
		{
			SchemaRevisionRepository repository = getComponent(SchemaRevisionRepository.class);
			IDatabase db = getComponent(IDatabase.class);
			for (ISchemaChanges changes : changeSets)
			{
				int revision = repository.getRevision(changes.getTableName());
				HashMap<Integer, List<String>> queries = changes.getSchemaUpdateQueries();
				boolean success = true;
				for (Integer rev : queries.keySet())
				{
					if (rev > revision)
					{
						output.write(String.format("Updating table %s from revision %d to revision %d", changes.getTableName(), revision, rev));
						for (String sql : queries.get(rev))
						{
							try
							{
								PreparedStatement query = db.prepare(sql);
								query.execute();
								revision = rev;
							}
							catch (SQLException e)
							{
								output.logException(e);
								output.writeColoured("Failed executing query:\n%s", sql);
								success = false;
								break;
							}
						}
						if (!success)
							break;
					}
				}
				repository.setRevision(changes.getTableName(), revision);
			}
		}
	}

	private void unregisterServices()
	{
		IMessagePump pump = MessagePump.GetPump();
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
	}

	private void RegisterEvents()
	{
		PluginManager pluginManager = this.getServer().getPluginManager();

		EventEngine engine = new EventEngine(
			container.getComponent(IOutput.class),
			container.getComponent(IScheduler.class),
			container.getComponents(IRunsafeEvent.class)
		);
		for (Listener listener : engine.getListeners())
		{
			pluginManager.registerEvents(listener, this);
			output.outputDebugToConsole(String.format("Registered event listener %s", listener.getClass().getName()), Level.FINER);
		}

		List<Listener> eventListeners = GetEvents();
		if (eventListeners != null && !eventListeners.isEmpty())
		{
			for (Listener listener : eventListeners)
			{
				pluginManager.registerEvents(listener, this);
				output.outputDebugToConsole(String.format("Registered event listener %s", listener.getClass().getName()), Level.FINER);
			}
		}

		List<IConfigurationChanged> configListeners = getComponents(IConfigurationChanged.class);
		if (configListeners != null && configListeners.size() > 0)
			getComponent(IConfiguration.class).setListeners(configListeners);

		if (eventListeners != null)
			output.outputDebugToConsole(String.format("Registered %d event listeners", eventListeners.size()), Level.FINE);
	}

	private void RegisterCommands()
	{
		for (RunsafeCommandHandler handler : this.GetLegacyCommands())
		{
			PluginCommand command = getCommand(handler.getName());

			if (command == null)
				output.outputToConsole(String.format("Command not found: %s - does it exist in plugin.yml?", handler.getName()));
			else
			{
				output.fine(String.format("Command handler for %s registered with bukkit.", handler.getName()));
				command.setExecutor(handler);
			}
		}
		for (BukkitCommandExecutor executor : this.GetCommands())
		{
			PluginCommand command = getCommand(executor.getName());

			if (command == null)
				output.outputToConsole(String.format("Command not found: %s - does it exist in plugin.yml?", executor.getName()));
			else
			{
				output.fine(String.format("Command handler for %s registered with bukkit.", executor.getName()));
				command.setExecutor(executor);
			}
		}
	}

	protected DefaultPicoContainer container = null;
	private IOutput output;
}
