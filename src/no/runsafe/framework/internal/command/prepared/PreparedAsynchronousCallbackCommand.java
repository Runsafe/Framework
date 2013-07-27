package no.runsafe.framework.internal.command.prepared;

import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.command.*;
import no.runsafe.framework.minecraft.RunsafeServer;

import java.util.Map;
import java.util.Stack;

public final class PreparedAsynchronousCallbackCommand extends PreparedCommand
{
	public PreparedAsynchronousCallbackCommand(
		ICommandExecutor executor, Stack<ICommandHandler> definingCommand, String[] args, Map<String, String> parameters)
	{
		super(executor, definingCommand, args, parameters);
	}

	@Override
	public String execute()
	{
		ICommandHandler target = command.peek();
		if (target instanceof AsyncCallbackCommand && !parameters.containsValue(null))
		{
			((AsyncCallbackCommand) target).Schedule(this);
			return ((ExecutableCommand) target).OnExecute(executor, parameters, arguments);
		}

		return usage(target);
	}

	public void schedule(final IScheduler scheduler)
	{
		final AsyncCallbackCommand target = (AsyncCallbackCommand) command.peek();
		scheduler.startAsyncTask(
			new Runnable()
			{
				@Override
				public void run()
				{
					try
					{
						final Object result = target.OnAsyncExecute(executor, parameters, arguments);
						scheduler.startSyncTask(
							new Runnable()
							{
								@SuppressWarnings("unchecked")
								@Override
								public void run()
								{
									try
									{
										target.SyncPostExecute(result);
									}
									catch (Exception e)
									{
										RunsafeServer.Instance.getDebugger().logException(e);
									}
								}
							}, 1L
						);
					}
					catch (Exception e)
					{
						RunsafeServer.Instance.getDebugger().logException(e);
					}
				}
			},
			1L
		);
	}
}
