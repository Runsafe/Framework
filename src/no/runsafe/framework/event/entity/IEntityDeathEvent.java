package no.runsafe.framework.event.entity;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.entity.RunsafeEntityDeathEvent;

public interface IEntityDeathEvent extends IRunsafeEvent
{
	public void OnEntityDeath(RunsafeEntityDeathEvent event);
}
