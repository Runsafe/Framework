package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerInteractEntityEvent;

public interface IPlayerInteractEntityEvent extends IRunsafeEvent
{
    void OnPlayerInteractEntityEvent(RunsafePlayerInteractEntityEvent event);
}
