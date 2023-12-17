package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityCreatePortalEvent;

public interface IEntityCreatePortalEvent extends IRunsafeEvent
{
	void OnEntityCreatePortal(RunsafeEntityCreatePortalEvent event);
}
