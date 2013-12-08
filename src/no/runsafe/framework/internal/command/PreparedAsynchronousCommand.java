package no.runsafe.framework.internal.command;

import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.command.*;
import no.runsafe.framework.internal.Debug;

import java.util.Map;
import java.util.Stack;

public final class PreparedAsynchronousCommand extends PreparedCommand
{
	public PreparedAsynchronousCommand(
		ICommandExecutor executor, Stack<ICommandHandler> definingCommand, String[] args, Map<String, String> parameters)
	{
		super(executor, definingCommand, args, parameters);
	}

	@Override
	public String execute()
	{
		ICommandHandler target = command.peek();
		if (target instanceof CommandScheduler && !parameters.containsValue(null))
		{
			schedule(((CommandScheduler) target).getScheduler());
			return ((ISyncExecute) target).OnExecute(executor, parameters);
		}

		return usage(target);
	}

	public String executeDirect()
	{
		IAsyncExecute target = (IAsyncExecute) command.peek();
		return target.OnAsyncExecute(executor, parameters);
	}

	public void schedule(final IScheduler scheduler)
	{
		final IAsyncExecute target = (IAsyncExecute) command.peek();
		scheduler.startAsyncTask(
			new Runnable()
			{
				@Override
				public void run()
				{
					try
					{
						final String result = target.OnAsyncExecute(executor, parameters);
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
					catch (Exception e)
					{
						Debug.Global().logException(e);
					}
				}
			},
			1L
		);
	}
}
