package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityChangeBlockEvent;

public interface IEntityChangeBlockEvent extends IRunsafeEvent
{
	public void OnEntityChangeBlockEvent(RunsafeEntityChangeBlockEvent event);
}
