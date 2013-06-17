package no.runsafe.framework.internal.command.prepared;

import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.command.AsyncCommand;
import no.runsafe.framework.api.command.Command;
import no.runsafe.framework.api.command.ExecutableCommand;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.text.ChatColour;

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

	public String executeDirect()
	{
		final AsyncCommand target = (AsyncCommand) command.peek();
		return target.OnAsyncExecute(executor, parameters, arguments);
	}

	public void schedule(final IScheduler scheduler)
	{
		final AsyncCommand target = (AsyncCommand) command.peek();
		scheduler.startAsyncTask(
			new Runnable()
			{
				@Override
				public void run()
				{
					try
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
