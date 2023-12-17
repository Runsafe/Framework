package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerPickupItemEvent;

public interface IPlayerPickupItemEvent extends IRunsafeEvent
{
	void OnPlayerPickupItemEvent(RunsafePlayerPickupItemEvent event);
}
