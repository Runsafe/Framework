package no.runsafe.framework.event.world;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.RunsafeWorld;

public interface IWorldInit extends IRunsafeEvent
{
	void OnWorldInit(RunsafeWorld world);
}
