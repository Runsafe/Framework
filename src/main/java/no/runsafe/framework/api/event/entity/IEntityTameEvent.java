package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityTameEvent;

public interface IEntityTameEvent extends IRunsafeEvent
{
	void OnEntityTame(RunsafeEntityTameEvent event);
}
