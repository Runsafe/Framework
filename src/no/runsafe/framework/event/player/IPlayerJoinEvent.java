package no.runsafe.framework.event.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerJoinEvent;

public interface IPlayerJoinEvent extends IRunsafeEvent
{
    public void OnPlayerJoinEvent(RunsafePlayerJoinEvent event);
}
