package no.runsafe.framework.api.event.world;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.event.IRunsafeEvent;

public interface IWorldLoad extends IRunsafeEvent
{
	void OnWorldLoad(IWorld world);
}
