package no.runsafe.framework;

import no.runsafe.framework.api.IConfiguration;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.command.ICommandHandler;
import no.runsafe.framework.api.event.IServerReady;
import no.runsafe.framework.files.PluginFileManager;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.LegacyMaterial;
import no.runsafe.framework.internal.command.BukkitCommandTabExecutor;
import no.runsafe.framework.internal.configuration.ConfigurationEngine;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.YamlConfiguration;

import javax.annotation.Nullable;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public abstract class RunsafePlugin extends InjectionPlugin
{
	static
	{
		Level consoleDebug = null;
		File globalConfig = new File("runsafe", "global.yml");
		if (globalConfig.exists())
		{
			//noinspection OverlyBroadCatchBlock
			try
			{
				YamlConfiguration global = new YamlConfiguration();
				global.load(globalConfig);
				String debug = (String) global.get("debug");
				if (debug != null)
					consoleDebug = Level.parse(debug);
			}
			catch (Exception ignored)
			{
				consoleDebug = Level.OFF;
			}
		}
		debugLevel = consoleDebug;
	}

	@SuppressWarnings({"CastToConcreteClass", "InstanceofInterfaces", "LocalVariableOfConcreteClass"})
	@Nullable
	public static ICommandHandler getPluginCommand(String name)
	{
		for (Map.Entry<String, InjectionPlugin> plugin : Instances.entrySet())
		{
			PluginCommand command = plugin.getValue().getCommand(name);
			if (command != null)
			{
				CommandExecutor executor = command.getExecutor();
				if (executor instanceof BukkitCommandTabExecutor)
				{
					BukkitCommandTabExecutor handler = (BukkitCommandTabExecutor) executor;
					return handler.getHandler();
				}
			}
		}
		return null;
	}

	@Override
	protected final void initializePlugin()
	{
		Instances.put(getName(), this);
		super.initializePlugin();

		scheduleReadyEvent(getComponent(IScheduler.class));

		output = getComponent(IDebug.class);
		if (debugLevel != null)
			output.setDebugLevel(debugLevel);
		output.debugFine("Standard components added.");

		// Temporary to generate some code..
		getInstance(LegacyMaterial.class).generate();
		System.exit(2);

		PluginSetup();
		output.debugFine("Plugin setup performed.");

		output.outputDebugToConsole("Initiation complete", Level.FINE);
	}

	/**
	 * Loads the given yaml from the plugins directory and returns an interface for accessing it.
	 *
	 * @param filename A file under the plugin folder to load.
	 * @return An API for accessing the contents of the given file.
	 */
	public IConfiguration loadConfiguration(String filename)
	{
		return getComponent(ConfigurationEngine.class).loadConfiguration(new File(getDataFolder(), filename));
	}

	protected abstract void PluginSetup();

	@SuppressWarnings("NonThreadSafeLazyInitialization")
	private static void scheduleReadyEvent(IScheduler scheduler)
	{
		if (scheduled == null)
		{
			// This is actually safe due to how plugins are initialized by bukkit..
			scheduled = scheduler.createSyncTimer(
				new Runnable()
				{
					@Override
					public void run()
					{
						List<IServerReady> listeners = getPluginAPI(IServerReady.class);
						if (listeners != null)
							for (IServerReady listener : listeners)
								listener.OnServerReady();
					}
				},
				0
			);
		}
	}

	/**
	 * Returns the class responsible for handling files for this plug-in instance.
	 *
	 * @return PluginFileManager
	 */
	public PluginFileManager getFileManager()
	{
		return getComponent(PluginFileManager.class);
	}

	private static final Level debugLevel;
	private static Object scheduled = null;
}
