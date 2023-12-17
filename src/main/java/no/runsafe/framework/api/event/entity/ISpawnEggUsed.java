package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.entity.RunsafeLivingEntity;

public interface ISpawnEggUsed extends IRunsafeEvent
{
	boolean OnSpawnEggUsed(RunsafeLivingEntity entity, ILocation location);
}
