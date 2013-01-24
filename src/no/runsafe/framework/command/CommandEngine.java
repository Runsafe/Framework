package no.runsafe.framework.command;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ICommandExecutor;
import no.runsafe.framework.server.RunsafeConsole;
import org.bukkit.command.PluginCommand;
import org.picocontainer.Startable;

import java.util.ArrayList;
import java.util.List;

public class CommandEngine implements Startable
{
	public CommandEngine(IOutput output, List<ICommandHandler> commands, RunsafePlugin plugin)
	{
		this.commands = commands;
		this.plugin = plugin;
		this.console = new RunsafeConsole(output);
		this.output = output;
	}

	@Override
	public void start()
	{
		for (BukkitCommandExecutor executor : this.GetCommands())
			HookCommand(plugin.getCommand(executor.getName()), executor);
	}

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

	protected List<BukkitCommandExecutor> GetCommands()
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
	private final List<ICommandHandler> commands;
	private final RunsafePlugin plugin;
}
