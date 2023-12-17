package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityExplodeEvent;

public interface IEntityExplode extends IRunsafeEvent
{
	void OnEntityExplode(RunsafeEntityExplodeEvent event);
}
