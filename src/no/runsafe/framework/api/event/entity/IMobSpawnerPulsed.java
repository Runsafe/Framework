package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.entity.RunsafeLivingEntity;

public interface IMobSpawnerPulsed extends IRunsafeEvent
{
	boolean OnMobSpawnerPulsed(RunsafeLivingEntity entity, RunsafeLocation location);
}
