package no.runsafe.framework.event.entity;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.entity.RunsafeEntityCreatePortalEvent;

public interface IEntityCreatePortalEvent extends IRunsafeEvent
{
	public void OnEntityCreatePortal(RunsafeEntityCreatePortalEvent event);
}
