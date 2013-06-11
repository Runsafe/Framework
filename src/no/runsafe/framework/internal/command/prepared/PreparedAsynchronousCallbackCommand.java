package no.runsafe.framework.internal.command.prepared;

import no.runsafe.framework.api.command.AsyncCallbackCommand;
import no.runsafe.framework.api.command.Command;
import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.IScheduler;

import java.util.HashMap;
import java.util.Stack;

public final class PreparedAsynchronousCallbackCommand extends PreparedCommand
{
	public PreparedAsynchronousCallbackCommand(
		ICommandExecutor executor, Stack<Command> definingCommand, String[] args, HashMap<String, String> parameters)
	{
		super(executor, definingCommand, args, parameters);
	}

	@Override
	public String execute()
	{
		Command target = command.peek();
		if (target instanceof AsyncCallbackCommand && !parameters.containsValue(null))
		{
			((AsyncCallbackCommand) target).Schedule(this);
			return ((ExecutableCommand) target).OnExecute(executor, parameters, arguments);
		}

		return usage(target);
	}

	public void Schedule(final IScheduler scheduler)
	{
		final AsyncCallbackCommand target = (AsyncCallbackCommand) command.peek();
		scheduler.startAsyncTask(
			new Runnable()
			{
				@Override
				public void run()
				{
					final Object result = target.OnAsyncExecute(executor, parameters, arguments);
					scheduler.startSyncTask(
						new Runnable()
						{
							@SuppressWarnings("unchecked")
							@Override
							public void run()
							{
								target.SyncPostExecute(result);
							}
						}, 1L
					);
				}
			},
			1L
		);
	}
}
