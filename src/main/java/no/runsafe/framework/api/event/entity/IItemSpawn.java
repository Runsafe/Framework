package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeItemSpawnEvent;

public interface IItemSpawn extends IRunsafeEvent
{
	void OnItemSpawn(RunsafeItemSpawnEvent event);
}
