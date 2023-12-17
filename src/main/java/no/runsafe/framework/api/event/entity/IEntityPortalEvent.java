package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityPortalEvent;

/**
 * Called when a non-player entity enters a portal.
 */
public interface IEntityPortalEvent extends IRunsafeEvent
{
	void OnEntityPortalEvent(RunsafeEntityPortalEvent event);
}
