package no.runsafe.framework.api.event.world;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.event.IRunsafeEvent;

public interface ISpawnChange extends IRunsafeEvent
{
	void OnSpawnChange(IWorld world, ILocation from);
}
