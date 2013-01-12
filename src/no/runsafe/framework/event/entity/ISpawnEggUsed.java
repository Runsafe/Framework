package no.runsafe.framework.event.entity;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.entity.RunsafeLivingEntity;

public interface ISpawnEggUsed extends IRunsafeEvent
{
	boolean OnSpawnEggUsed(RunsafeLivingEntity entity, RunsafeLocation location);
}
