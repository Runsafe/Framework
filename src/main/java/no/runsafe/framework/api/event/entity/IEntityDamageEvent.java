package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageEvent;

public interface IEntityDamageEvent extends IRunsafeEvent
{
	void OnEntityDamage(RunsafeEntityDamageEvent event);
}
