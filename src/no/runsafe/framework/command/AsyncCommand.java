package no.runsafe.framework.command;

import no.runsafe.framework.command.prepared.PreparedAsynchronousCommand;
import no.runsafe.framework.server.ICommandExecutor;
import no.runsafe.framework.timer.IScheduler;

import java.util.HashMap;

public abstract class AsyncCommand extends ExecutableCommand
{
	public AsyncCommand(String name, String description, String permission, IScheduler scheduler, String... args)
	{
		super(name, description, permission, args);
		this.scheduler = scheduler;
	}

	@Override
	public String OnExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments)
	{
		return null;
	}

	public abstract String OnAsyncExecute(ICommandExecutor executor, HashMap<String, String> parameters, String[] arguments);

	public void Schedule(PreparedAsynchronousCommand target)
	{
		target.Schedule(scheduler);
	}

	private final IScheduler scheduler;
}
