package no.runsafe.framework.api.event.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityShootBowEvent;

public interface IEntityShootBowEvent extends IRunsafeEvent
{
    void OnEntityShootBowEvent(RunsafeEntityShootBowEvent event);
}
