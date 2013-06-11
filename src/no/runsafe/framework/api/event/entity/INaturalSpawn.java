package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;

public interface INaturalSpawn extends IRunsafeEvent
{
	public boolean OnNaturalSpawn(RunsafeEntity entity, RunsafeLocation location);
}
