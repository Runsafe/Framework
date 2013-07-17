package no.runsafe.framework.internal.command;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.ICommandHandler;
import no.runsafe.framework.minecraft.RunsafeConsole;
import org.bukkit.command.PluginCommand;
import org.picocontainer.Startable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class handles the registration of command objects with bukkit.
 */
public final class CommandEngine implements Startable
{
	/**
	 * This constructor in order for plugins without commands to start without exceptions
	 */
	public CommandEngine()
	{
		this.commands = null;
		this.plugin = null;
		this.console = null;
		this.output = null;
	}

	/**
	 * @param output   The console to output debug information to
	 * @param commands The commands provided by the plugin
	 * @param plugin   The plugin
	 */
	public CommandEngine(IOutput output, ICommandHandler[] commands, RunsafePlugin plugin)
	{
		this.commands = commands;
		this.plugin = plugin;
		this.console = new RunsafeConsole(output);
		this.output = output;
	}

	/**
	 * Hooks the commands into bukkit when plugin starts
	 */
	@Override
	public void start()
	{
		if (commands != null)
			for (BukkitCommandTabExecutor executor : getCommands())
				hookCommand(plugin.getCommand(executor.getName()), executor);
	}

	/**
	 * Not used
	 */
	@Override
	public void stop()
	{
	}

	private void hookCommand(PluginCommand command, BukkitCommandTabExecutor executor)
	{
		if (command == null)
			output.logError("Command not found: %s - does it exist in plugin.yml?", executor.getName());
		else
		{
			command.setExecutor(executor);
			output.finer("Command handler for %s registered with bukkit.", executor.getName());
		}
	}

	private List<BukkitCommandTabExecutor> getCommands()
	{
		ArrayList<BukkitCommandTabExecutor> handlers = new ArrayList<BukkitCommandTabExecutor>();
		for (ICommandHandler command : commands)
		{
			command.setConsole(output);
			handlers.add(new BukkitCommandTabExecutor(command, console, output));
		}
		return handlers;
	}

	private final ICommandExecutor console;
	private final IOutput output;
	private final ICommandHandler[] commands;
	private final RunsafePlugin plugin;
}
