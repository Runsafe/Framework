package no.runsafe.framework.internal.command.prepared;

import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.ICommandHandler;

import java.util.Map;
import java.util.Stack;

public final class PreparedSynchronousCommand extends PreparedCommand
{
	public PreparedSynchronousCommand(
		ICommandExecutor executor, Stack<ICommandHandler> definingCommand, String[] args, Map<String, String> parameters)
	{
		super(executor, definingCommand, args, parameters);
	}

	@Override
	public String execute()
	{
		ICommandHandler target = command.peek();
		if (target instanceof ExecutableCommand && !parameters.containsValue(null))
			return ((ExecutableCommand) target).OnExecute(executor, parameters, arguments);

		return usage(target);
	}
}
