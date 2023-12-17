package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageByEntityEvent;

public interface IEntityDamageByEntityEvent extends IRunsafeEvent
{
	void OnEntityDamageByEntity(RunsafeEntityDamageByEntityEvent event);
}
