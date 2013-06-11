package no.runsafe.framework.internal.command;

import no.runsafe.framework.api.IScheduler;

@Deprecated
public abstract class AsyncCallbackCommand extends no.runsafe.framework.api.command.AsyncCallbackCommand
{
	public AsyncCallbackCommand(String name, String description, String permission, IScheduler scheduler, String... args)
	{
		super(name, description, permission, scheduler, args);
	}
}
