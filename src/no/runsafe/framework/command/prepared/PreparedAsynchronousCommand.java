package no.runsafe.framework.command.prepared;

import no.runsafe.framework.command.AsyncCommand;
import no.runsafe.framework.command.Command;
import no.runsafe.framework.command.ExecutableCommand;
import no.runsafe.framework.server.ICommandExecutor;
import no.runsafe.framework.timer.IScheduler;

import java.util.HashMap;
import java.util.Stack;

public final class PreparedAsynchronousCommand extends PreparedCommand
{
	public PreparedAsynchronousCommand(
		ICommandExecutor executor, Stack<Command> definingCommand, String[] args, HashMap<String, String> parameters)
	{
		super(executor, definingCommand, args, parameters);
	}

	@Override
	public String execute()
	{
		Command target = command.peek();
		if (target instanceof AsyncCommand && !parameters.containsValue(null))
		{
			((AsyncCommand) target).Schedule(this);
			return ((ExecutableCommand) target).OnExecute(executor, parameters, arguments);
		}

		return usage(target);
	}

	public void Schedule(final IScheduler scheduler)
	{
		final AsyncCommand target = (AsyncCommand) command.peek();
		scheduler.startAsyncTask(
			new Runnable()
			{
				@Override
				public void run()
				{
					final String result = target.OnAsyncExecute(executor, parameters, arguments);
					if (result != null && executor != null)
						scheduler.startSyncTask(
							new Runnable()
							{
								@Override
								public void run()
								{
									executor.sendColouredMessage(result);
								}
							}, 1L
						);
				}
			},
			1L
		);
	}
}
