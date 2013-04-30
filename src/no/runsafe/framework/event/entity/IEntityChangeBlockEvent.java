package no.runsafe.framework.event.entity;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.entity.RunsafeEntityChangeBlockEvent;

public interface IEntityChangeBlockEvent extends IRunsafeEvent
{
	public void OnEntityChangeBlockEvent(RunsafeEntityChangeBlockEvent event);
}
