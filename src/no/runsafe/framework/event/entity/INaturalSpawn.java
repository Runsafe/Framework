package no.runsafe.framework.event.entity;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.entity.RunsafeEntity;

public interface INaturalSpawn extends IRunsafeEvent
{
	public boolean OnNaturalSpawn(RunsafeEntity entity, RunsafeLocation location);
}
