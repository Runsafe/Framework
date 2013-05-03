package no.runsafe.framework.event.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerPickupItemEvent;

public interface IPlayerPickupItemEvent extends IRunsafeEvent
{
	public void OnPlayerPickupItemEvent(RunsafePlayerPickupItemEvent event);
}
