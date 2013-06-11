package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.entity.RunsafeLivingEntity;

public interface ISpawnEggUsed extends IRunsafeEvent
{
	boolean OnSpawnEggUsed(RunsafeLivingEntity entity, RunsafeLocation location);
}
