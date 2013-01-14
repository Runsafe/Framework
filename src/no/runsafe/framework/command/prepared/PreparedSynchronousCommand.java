package no.runsafe.framework.command.prepared;

import no.runsafe.framework.command.Command;
import no.runsafe.framework.command.ExecutableCommand;
import no.runsafe.framework.server.ICommandExecutor;

import java.util.HashMap;
import java.util.Stack;

public final class PreparedSynchronousCommand extends PreparedCommand
{
	public PreparedSynchronousCommand(
		ICommandExecutor executor, Stack<Command> definingCommand, String[] args, HashMap<String, String> parameters)
	{
		super(executor, definingCommand, args, parameters);
	}

	@Override
	public String execute()
	{
		Command target = command.peek();
		if (target instanceof ExecutableCommand && !parameters.containsValue(null))
			return ((ExecutableCommand) target).OnExecute(executor, parameters, arguments);

		return usage(target);
	}
}
