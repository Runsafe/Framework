package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeProjectileHitEvent;

public interface IProjectileHitEvent extends IRunsafeEvent
{
	void OnProjectileHit(RunsafeProjectileHitEvent event);
}
