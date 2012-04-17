package no.runsafe.framework.event.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerInteractEvent;

public interface IPlayerInteractEvent extends IRunsafeEvent
{
    public void OnPlayerInteractEvent(RunsafePlayerInteractEvent event);
}
