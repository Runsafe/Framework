package no.runsafe.framework.command;

import no.runsafe.framework.command.prepared.PreparedAsynchronousCallbackCommand;
import no.runsafe.framework.server.ICommandExecutor;
import no.runsafe.framework.timer.IScheduler;

import java.util.HashMap;

public abstract class AsyncCallbackCommand<T> extends ExecutableCommand
{
	public AsyncCallbackCommand(String name, String description, String permission, IScheduler scheduler, String... args)
	{
		super(name, description, permission, args);
		this.scheduler = scheduler;
	}

	@Override
	public String OnExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		return null;
	}

	public T OnAsyncExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		return OnAsyncExecute(executor, parameters);
	}

	public abstract T OnAsyncExecute(ICommandExecutor executor, HashMap<String, String> parameters);

	public abstract void SyncPostExecute(T result);

	public void Schedule(PreparedAsynchronousCallbackCommand target)
	{
		target.Schedule(scheduler);
	}

	private final IScheduler scheduler;
}
