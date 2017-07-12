package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityTeleportEvent;

/**
 * Called when a non-player entity tries to teleport.
 */
public interface IEntityTeleportEvent extends IRunsafeEvent
{
	void OnEntityTeleport(RunsafeEntityTeleportEvent event);
}
