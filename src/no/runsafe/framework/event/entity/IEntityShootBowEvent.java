package no.runsafe.framework.event.entity;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.entity.RunsafeEntityShootBowEvent;

public interface IEntityShootBowEvent extends IRunsafeEvent
{
    public void OnEntityShootBowEvent(RunsafeEntityShootBowEvent event);
}
