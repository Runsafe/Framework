package no.runsafe.framework;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.IConfiguration;
import no.runsafe.framework.api.IKernel;
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public abstract class RunsafePlugin extends InjectionPlugin
{
	@Nullable
	public static <T extends RunsafePlugin> T getPlugin(Class<T> type)
	{
		return pluginContainer.getComponent(type);
	}

	@Nullable
	public static IKernel getPlugin(String name)
	{
		for (InjectionPlugin plugin : pluginContainer.getComponents(InjectionPlugin.class))
			if (plugin.getName().equals(name))
				return plugin;

		return null;
	}

	public static List<RunsafePlugin> getPlugins(@Nonnull String name)
	{
		if (name.equals("*"))
			return pluginContainer.getComponents(RunsafePlugin.class);

		name = name.toLowerCase();
		List<RunsafePlugin> plugins = new ArrayList<RunsafePlugin>(1);
		for (RunsafePlugin plugin : pluginContainer.getComponents(RunsafePlugin.class))
			if (plugin.getName().toLowerCase().startsWith(name))
				plugins.add(plugin);

		return plugins;
	}

	public static <T> List<T> getAllPluginComponents(Class<T> type)
	{
		List<T> result = Lists.newArrayList();
		for (IKernel kernel : pluginContainer.getComponents(IKernel.class))
		{
			List<T> implementations = kernel.getComponents(type);
			if (implementations != null && !implementations.isEmpty())
				result.addAll(implementations);
		}
		return result;
	}

	@SuppressWarnings({"InstanceofInterfaces", "LocalVariableOfConcreteClass", "CastToConcreteClass"})
	@Nullable
	public static ICommandHandler getPluginCommand(String name)
	{
		for (InjectionPlugin plugin : pluginContainer.getComponents(InjectionPlugin.class))
		{
			PluginCommand command = plugin.getCommand(name);
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
