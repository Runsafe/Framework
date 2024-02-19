package no.runsafe.framework.internal.command;

import com.google.common.collect.ImmutableList;
import no.runsafe.framework.api.IKernel;
import no.runsafe.framework.api.command.IBranchingExecution;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.ICommandHandler;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.minecraft.RunsafeConsole;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;

import javax.annotation.Nonnull;
import java.util.*;

/**
 * This class handles the registration of command objects with bukkit.
 */
public final class Engine
{
	/**
	 * @param output   The console to output debug information to
	 * @param debugger Debug output handler
	 */
	public Engine(@Nonnull IConsole output, @Nonnull IDebug debugger, @Nonnull IKernel kernel)
	{
		this.kernel = kernel;
		this.output = debugger;
		console = new RunsafeConsole(output);
		consoleLog = output;
	}

	public void hookCommand(PluginCommand command, ITabExecutor executor)
	{
		if (command == null)
			console.sendColouredMessage("Command not found: %s - does it exist in plugin.yml?", executor.getName());
		else
		{
			command.setExecutor(executor);
			output.debugFiner("Command handler for %s registered with bukkit.", executor.getName());
		}
	}

	public void unhookCommand(PluginCommand command)
	{
		CommandExecutor executor = command.getExecutor();
		command.setExecutor(null);
		if (executor instanceof ITabExecutor)
			output.debugFiner("Command handler for %s unregistered from bukkit.", ((ITabExecutor) executor).getName());
	}

	public Iterable<ITabExecutor> getCommands()
	{
		List<ICommandHandler> commands = kernel.getComponents(ICommandHandler.class);
		if (commands.isEmpty())
		{
			consoleLog.logError("Command subsystem started without any defined commands!");
			return ImmutableList.of();
		}

		Map<String, BranchingCommandTabExecutor> branches = new HashMap<>(0);
		Collection<ITabExecutor> handlers = new ArrayList<>(commands.size());
		for (ICommandHandler command : commands)
		{
			command.setConsole(output);
			if (command instanceof IBranchingExecution)
			{
				if (branches.containsKey(command.getName()))
					branches.get(command.getName()).addBranch(command);
				else
				{
					branches.put(command.getName(), new BranchingCommandTabExecutor(command, console, output, consoleLog));
					handlers.add(branches.get(command.getName()));
				}
			}
			else
			{
				handlers.add(new BukkitCommandTabExecutor(command, console, output, consoleLog));
			}
		}
		return handlers;
	}

	@Nonnull
	private final ICommandExecutor console;
	@Nonnull
	private final IDebug output;
	@Nonnull
	private final IConsole consoleLog;
	@Nonnull
	private final IKernel kernel;
}
