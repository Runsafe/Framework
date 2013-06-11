package no.runsafe.framework.api.event.world;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeWorld;

public interface ISpawnChange extends IRunsafeEvent
{
	void OnSpawnChange(RunsafeWorld world, RunsafeLocation from);
}
