package no.runsafe.framework.api.event.world;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.event.IRunsafeEvent;

public interface IWorldUnload extends IRunsafeEvent
{
	void OnWorldUnload(IWorld world);
}
