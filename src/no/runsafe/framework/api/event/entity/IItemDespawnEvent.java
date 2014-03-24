package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeItemDespawnEvent;

public interface IItemDespawnEvent extends IRunsafeEvent
{
	boolean OnItemDespawn(RunsafeItemDespawnEvent event);
}
