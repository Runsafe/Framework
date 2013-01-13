package no.runsafe.framework.command;

import no.runsafe.framework.server.player.RunsafePlayer;
import no.runsafe.framework.timer.IScheduler;

import java.util.HashMap;

public abstract class AsyncCommand extends ExecutableCommand
{
	public AsyncCommand(String name, String description, String permission, IScheduler scheduler, String... args)
	{
		super(name, description, permission, args);
		this.scheduler = scheduler;
	}

	public abstract void OnAsyncExecute(RunsafePlayer executor, HashMap<String, String> parameters, String[] arguments);

	public void Schedule(PreparedCommand target)
	{
		target.Schedule(scheduler);
	}

	private final IScheduler scheduler;
}
