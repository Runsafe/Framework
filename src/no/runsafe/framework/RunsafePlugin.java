package no.runsafe.framework;

import no.runsafe.framework.command.*;
import no.runsafe.framework.configuration.ConfigurationEngine;
import no.runsafe.framework.configuration.RunsafeConfigurationHandler;
import no.runsafe.framework.database.RunsafeDatabaseHandler;
import no.runsafe.framework.database.SchemaUpdater;
import no.runsafe.framework.event.EventEngine;
import no.runsafe.framework.event.IPluginDisabled;
import no.runsafe.framework.event.IPluginEnabled;
import no.runsafe.framework.hook.*;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.output.RunsafeOutputHandler;
import no.runsafe.framework.plugin.IPluginUpdate;
import no.runsafe.framework.server.RunsafeServer;
import no.runsafe.framework.server.player.RunsafePlayer;
import no.runsafe.framework.timer.Scheduler;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.behaviors.Caching;

import java.io.IOException;
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

	/**
	 * Get the first implementation of a given API from any plugin
	 *
	 * @param apiType The interface specification needed
	 * @return The first available implementation of the interface
	 */
	public static <T> T getFirstPluginAPI(Class<T> apiType)
	{
		for (RunsafePlugin plugin : Instances.values())
		{
			T instance = plugin.getComponent(apiType);
			if (instance != null)
				return instance;
		}
		return null;
	}

	/**
	 * Get all implementations of a given API from all plugins
	 *
	 * @param apiType The interface specification needed
	 * @return The first available implementation of the interface
	 */
	public static <T> List<T> getPluginAPI(Class<T> apiType)
	{
		List<T> results = new ArrayList<T>();
		for (RunsafePlugin plugin : Instances.values())
		{
			List<T> instance = plugin.getComponents(apiType);
			if (instance != null)
				results.addAll(instance);
		}
		return results;
	}

	@Override
	public void onEnable()
	{
		if (container == null)
			initializePlugin();
		IOutput console = getComponent(IOutput.class);
		console.fine("Plugin initialized.");

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
		for (IPluginDisabled impl : getComponents(IPluginDisabled.class))
			impl.OnPluginDisabled();
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

	@Deprecated
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

//	protected List<BukkitCommandExecutor> GetCommands()
//	{
//		ICommandExecutor console = new RunsafeConsole(output);
//		ArrayList<BukkitCommandExecutor> handlers = new ArrayList<BukkitCommandExecutor>();
//		for (ICommandHandler command : getComponents(ICommandHandler.class))
//		{
//			command.setConsole(getComponent(IOutput.class));
//			handlers.add(new BukkitCommandExecutor(command, console));
//		}
//		return handlers;
//	}

	protected abstract void PluginSetup();

	private void initializePlugin()
	{
		if (RunsafeServer.Instance == null)
			RunsafeServer.Instance = new RunsafeServer(this.getServer());
		Instances.put(getName(), this);

		container = new DefaultPicoContainer(new Caching());

		addStandardComponents();

		output = getComponent(IOutput.class);
		output.fine("Standard components added.");
		output.outputDebugToConsole("Wiring up plugin", Level.FINE);

		addFrameworkHooks();
		output.fine("Plugin framework hooks added.");

		this.PluginSetup();
		output.fine("Plugin setup performed.");

		RegisterCommands();
		this.container.start();
		output.outputDebugToConsole("Initiation complete", Level.FINE);
	}

	private void addStandardComponents()
	{
		this.container.addComponent(this);
		this.container.addComponent(ConfigurationEngine.class);
		this.container.addComponent(this.getServer().getPluginManager());
		this.container.addComponent(new RunsafeServer(this.getServer()));
		this.container.addComponent(this.getLogger());
		this.container.addComponent(RunsafeConfigurationHandler.class);
		this.container.addComponent(RunsafeOutputHandler.class);
		this.container.addComponent(RunsafeDatabaseHandler.class);
		this.container.addComponent(new Scheduler(this.getServer().getScheduler(), this));
		this.container.addComponent(SchemaUpdater.class);
		this.container.addComponent(EventEngine.class);
		this.container.addComponent(CommandEngine.class);
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

	@Deprecated
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
//		for (BukkitCommandExecutor executor : this.GetCommands())
//		{
//			PluginCommand command = getCommand(executor.getName());
//
//			if (command == null)
//				output.outputToConsole(String.format("Command not found: %s - does it exist in plugin.yml?", executor.getName()));
//			else
//			{
//				output.fine(String.format("Command handler for %s registered with bukkit.", executor.getName()));
//				command.setExecutor(executor);
//			}
//		}
	}

	protected DefaultPicoContainer container = null;
	private IOutput output;
}
