package no.runsafe.framework;

import no.runsafe.framework.api.IConfiguration;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.command.ICommandHandler;
import no.runsafe.framework.api.event.IServerReady;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.files.PluginFileManager;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.command.BukkitCommandTabExecutor;
import no.runsafe.framework.internal.configuration.ConfigurationEngine;
import no.runsafe.framework.internal.log.Debug;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;

import javax.annotation.Nullable;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public abstract class RunsafePlugin extends InjectionPlugin
{
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
		super.initializePlugin();

		output = getComponent(IDebug.class);
		output.debugFine("Standard components added.");

		PluginSetup();
		output.debugFine("Plugin setup performed.");

		scheduleReadyEvent();
		output.outputDebugToConsole("Initiation complete", Level.FINE);
		Debug.Global().debugFine("Test global debugger from plugin");
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

	private void scheduleReadyEvent()
	{
		final List<IServerReady> listeners = getComponents(IServerReady.class);
		if (listeners != null && !listeners.isEmpty())
			getComponent(IScheduler.class).createSyncTimer(
				new Runnable()
				{
					@Override
					public void run()
					{
						for (IServerReady listener : listeners)
							listener.OnServerReady();
					}
				},
				0
			);
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
}
