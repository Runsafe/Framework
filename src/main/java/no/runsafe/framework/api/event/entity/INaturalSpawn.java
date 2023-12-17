package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;

public interface INaturalSpawn extends IRunsafeEvent
{
	boolean OnNaturalSpawn(RunsafeEntity entity, ILocation location);
}
