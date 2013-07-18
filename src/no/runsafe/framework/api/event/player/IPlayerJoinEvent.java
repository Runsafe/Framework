package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerJoinEvent;

public interface IPlayerJoinEvent extends IRunsafeEvent
{
    void OnPlayerJoinEvent(RunsafePlayerJoinEvent event);
}
