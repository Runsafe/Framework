package no.runsafe.framework.api.event.world;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.event.IRunsafeEvent;

public interface IWorldInit extends IRunsafeEvent
{
	void OnWorldInit(IWorld world);
}
