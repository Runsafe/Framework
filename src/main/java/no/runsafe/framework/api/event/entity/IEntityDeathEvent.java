package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDeathEvent;

public interface IEntityDeathEvent extends IRunsafeEvent
{
	void OnEntityDeath(RunsafeEntityDeathEvent event);
}
