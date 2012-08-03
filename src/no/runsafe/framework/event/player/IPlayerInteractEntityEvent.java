package no.runsafe.framework.event.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerInteractEntityEvent;

public interface IPlayerInteractEntityEvent extends IRunsafeEvent
{
    public void OnPlayerInteractEntityEvent(RunsafePlayerInteractEntityEvent event);
}
