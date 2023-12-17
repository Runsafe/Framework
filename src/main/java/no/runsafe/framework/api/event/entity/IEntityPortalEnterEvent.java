package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityPortalEnterEvent;

public interface IEntityPortalEnterEvent extends IRunsafeEvent
{
	void OnEntityPortalEnter(RunsafeEntityPortalEnterEvent event);
}
