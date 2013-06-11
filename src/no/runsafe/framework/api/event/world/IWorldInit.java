package no.runsafe.framework.api.event.world;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.RunsafeWorld;

public interface IWorldInit extends IRunsafeEvent
{
	void OnWorldInit(RunsafeWorld world);
}
