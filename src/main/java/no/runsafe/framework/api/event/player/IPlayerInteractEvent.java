package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerInteractEvent;

public interface IPlayerInteractEvent extends IRunsafeEvent
{
    void OnPlayerInteractEvent(RunsafePlayerInteractEvent event);
}
