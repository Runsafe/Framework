package no.runsafe.framework.command;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ICommandExecutor;
import no.runsafe.framework.server.RunsafeConsole;
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
			for (BukkitCommandExecutor executor : GetCommands())
				HookCommand(plugin.getCommand(executor.getName()), executor);
	}

	/**
	 * Not used
	 */
	@Override
	public void stop()
	{
	}

	private void HookCommand(PluginCommand command, BukkitCommandExecutor executor)
	{
		if (command == null)
			output.outputToConsole(String.format("Command not found: %s - does it exist in plugin.yml?", executor.getName()));
		else
		{
			command.setExecutor(executor);
			output.fine("Command handler for %s registered with bukkit.", executor.getName());
		}
	}

	private List<BukkitCommandExecutor> GetCommands()
	{
		ArrayList<BukkitCommandExecutor> handlers = new ArrayList<BukkitCommandExecutor>();
		for (ICommandHandler command : commands)
		{
			command.setConsole(output);
			handlers.add(new BukkitCommandExecutor(command, console));
		}
		return handlers;
	}

	private final ICommandExecutor console;
	private final IOutput output;
	private final ICommandHandler[] commands;
	private final RunsafePlugin plugin;
}
