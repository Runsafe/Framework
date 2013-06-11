package no.runsafe.framework.api.event.world;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.RunsafeWorld;

public interface IWorldUnload extends IRunsafeEvent
{
	void OnWorldUnload(RunsafeWorld world);
}
