package no.runsafe.framework.internal.command;

import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.command.ICommandHandler;
import no.runsafe.framework.api.command.ISyncExecute;
import no.runsafe.framework.api.command.argument.IArgumentList;

import java.util.Stack;

public final class PreparedSynchronousCommand extends PreparedCommand
{
	public PreparedSynchronousCommand(
		ICommandExecutor executor, Stack<ICommandHandler> definingCommand, String[] args, IArgumentList parameters)
	{
		super(executor, definingCommand, args, parameters);
	}

	@Override
	public String execute()
	{
		ICommandHandler target = command.peek();
		if (target instanceof ISyncExecute && !parameters.isAborted())
			return ((ISyncExecute) target).OnExecute(executor, parameters);

		return usage(target);
	}

	@Override
	public String executeDirect()
	{
		return execute();
	}
}
