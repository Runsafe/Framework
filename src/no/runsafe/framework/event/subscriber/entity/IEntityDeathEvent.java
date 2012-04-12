package no.runsafe.framework.event.subscriber.entity;

import no.runsafe.framework.event.subscriber.IRunsafeEvent;
import no.runsafe.framework.event.server.entity.RunsafeEntityDeathEvent;

public interface IEntityDeathEvent extends IRunsafeEvent
{
	public void OnEntityDeath(RunsafeEntityDeathEvent event);
}
