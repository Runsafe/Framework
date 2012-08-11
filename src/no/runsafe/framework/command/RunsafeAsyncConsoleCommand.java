package no.runsafe.framework.command;

import no.runsafe.framework.server.player.RunsafePlayer;
import no.runsafe.framework.timer.IScheduler;

public abstract class RunsafeAsyncConsoleCommand extends RunsafeAsyncCommand
{
	public RunsafeAsyncConsoleCommand(String name, IScheduler scheduler, String... params)
	{
		super(name, scheduler, params);
	}

	@Override
	public boolean Execute(RunsafePlayer player, String[] args)
	{
		player.sendMessage("This command must be used from the console.");
		return true;
	}
}
