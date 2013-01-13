package no.runsafe.framework.command;

import no.runsafe.framework.timer.IScheduler;

@Deprecated
public abstract class RunsafeAsyncPlayerCommand extends RunsafeAsyncCommand
{
	public RunsafeAsyncPlayerCommand(String name, IScheduler scheduler, String... params)
	{
		super(name, scheduler, params);
	}

	@Override
	public boolean Execute(String[] args)
	{
		Console.write("This command cannot be used from the console.");
		return true;
	}
}
