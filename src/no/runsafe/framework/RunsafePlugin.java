package no.runsafe.framework;

import no.runsafe.framework.command.BukkitCommandExecutor;
import no.runsafe.framework.command.ICommandHandler;
import no.runsafe.framework.output.IOutput;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
			}
		}
		debugLevel = consoleDebug;
	}

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
	protected final void initializePlugin()
	{
		Instances.put(getName(), this);
		super.initializePlugin();

		output = getComponent(IOutput.class);
		if (debugLevel != null)
			output.setDebugLevel(debugLevel);
		output.fine("Standard components added.");

		this.PluginSetup();
		output.fine("Plugin setup performed.");

		output.outputDebugToConsole("Initiation complete", Level.FINE);
	}

	protected abstract void PluginSetup();

	private static final Level debugLevel;
}
