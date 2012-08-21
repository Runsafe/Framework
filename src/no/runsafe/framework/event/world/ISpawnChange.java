package no.runsafe.framework.event.world;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.RunsafeWorld;

public interface ISpawnChange extends IRunsafeEvent
{
	void OnSpawnChange(RunsafeWorld world, RunsafeLocation from);
}
