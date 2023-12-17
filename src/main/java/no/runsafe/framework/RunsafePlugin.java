package no.runsafe.framework;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.IConfiguration;
import no.runsafe.framework.api.IKernel;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.command.ICommandHandler;
import no.runsafe.framework.api.event.IServerReady;
import no.runsafe.framework.api.filesystem.IPluginDataFile;
import no.runsafe.framework.api.filesystem.IPluginFileManager;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.command.ITabExecutor;
import no.runsafe.framework.internal.configuration.ConfigurationEngine;
import no.runsafe.framework.internal.filesystem.PluginDataFile;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class RunsafePlugin extends InjectionPlugin implements IPluginFileManager
{
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

		String lookup = name.toLowerCase();
		List<RunsafePlugin> plugins = new ArrayList<RunsafePlugin>(1);
		for (RunsafePlugin plugin : pluginContainer.getComponents(RunsafePlugin.class))
			if (plugin.getName().toLowerCase().startsWith(lookup))
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
				safeAddAll(result, implementations);
		}
		return result;
	}

	@Nullable
	public static ICommandHandler getPluginCommand(String name)
	{
		for (InjectionPlugin plugin : pluginContainer.getComponents(InjectionPlugin.class))
		{
			PluginCommand command = plugin.getCommand(name);
			if (command != null)
			{
				CommandExecutor executor = command.getExecutor();
				if (executor instanceof ITabExecutor)
				{
					ITabExecutor handler = (ITabExecutor) executor;
					return handler.getHandler();
				}
			}
		}
		return null;
	}

	@Override
	public IPluginDataFile getFile(String file)
	{
		return new PluginDataFile(getComponent(IConsole.class), getName(), getDataFolder(), file);
	}

	@Override
	protected void initializePlugin()
	{
		super.initializePlugin();

		output = getComponent(IDebug.class);
		output.debugFine("Standard components added.");

		pluginSetup();
		output.debugFine("Plugin setup performed.");

		scheduleReadyEvent();
		output.debugFine("Initiation complete");
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

	protected abstract void pluginSetup();

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

	private static <T> void safeAddAll(List<T> result, List<T> implementations)
	{
		for (T implementation : implementations)
			if (!result.contains(implementation))
				result.add(implementation);
	}
}
