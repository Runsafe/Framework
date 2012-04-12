package no.runsafe.framework.event.subscriber.entity;

import no.runsafe.framework.event.subscriber.IRunsafeEvent;
import no.runsafe.framework.event.server.entity.RunsafeEntityDamageByEntityEvent;

public interface IEntityDamageByEntityEvent extends IRunsafeEvent
{
	void OnEntityDamageByEntity(RunsafeEntityDamageByEntityEvent event);
}
