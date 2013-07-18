package no.runsafe.framework;

import no.runsafe.framework.api.IConfiguration;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.command.ICommandHandler;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.command.BukkitCommandTabExecutor;
import no.runsafe.framework.internal.configuration.ConfigurationEngine;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.YamlConfiguration;

import javax.annotation.Nullable;
import java.io.File;
import java.util.logging.Level;

public abstract class RunsafePlugin extends InjectionPlugin
{
	static
	{
		Level consoleDebug = null;
		if (new File("runsafe/global.yml").exists())
		{
			try
			{
				YamlConfiguration global = new YamlConfiguration();
				global.load("runsafe/global.yml");
				String debug = (String) global.get("debug");
				if (debug != null)
					consoleDebug = Level.parse(debug);
			}
			catch (Exception e)
			{
				consoleDebug = Level.OFF;
			}
		}
		debugLevel = consoleDebug;
	}

	@Nullable
	public static ICommandHandler getPluginCommand(String name)
	{
		for (String plugin : Instances.keySet())
		{
			PluginCommand command = Instances.get(plugin).getCommand(name);
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

		output = getComponent(IOutput.class);
		if (debugLevel != null)
			output.setDebugLevel(debugLevel);
		output.fine("Standard components added.");

		PluginSetup();
		output.fine("Plugin setup performed.");

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
		return getComponent(ConfigurationEngine.class).loadConfiguration(String.format("plugins/%s/%s", getName(), filename));
	}

	protected abstract void PluginSetup();

	private static final Level debugLevel;
}
