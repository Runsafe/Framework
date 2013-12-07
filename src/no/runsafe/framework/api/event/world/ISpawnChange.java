package no.runsafe.framework.api.event.world;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.RunsafeLocation;

public interface ISpawnChange extends IRunsafeEvent
{
	void OnSpawnChange(IWorld world, RunsafeLocation from);
}
