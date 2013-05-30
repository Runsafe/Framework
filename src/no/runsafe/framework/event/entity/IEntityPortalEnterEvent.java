package no.runsafe.framework.event.entity;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.entity.RunsafeEntityPortalEnterEvent;

public interface IEntityPortalEnterEvent extends IRunsafeEvent
{
	public void OnEntityPortalEnter(RunsafeEntityPortalEnterEvent event);
}
