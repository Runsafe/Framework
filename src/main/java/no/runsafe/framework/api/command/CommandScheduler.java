package no.runsafe.framework.api.command;

import no.runsafe.framework.api.IScheduler;

import javax.annotation.Nonnull;

public interface CommandScheduler extends ISyncExecute
{
	@Nonnull
	IScheduler getScheduler();
}
