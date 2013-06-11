package no.runsafe.framework.internal.command;

import no.runsafe.framework.api.IScheduler;

@Deprecated
public abstract class AsyncCommand extends no.runsafe.framework.api.command.AsyncCommand
{
	public AsyncCommand(String name, String description, String permission, IScheduler scheduler, String... args)
	{
		super(name, description, permission, scheduler, args);
	}
}
