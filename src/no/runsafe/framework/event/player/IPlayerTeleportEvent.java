package no.runsafe.framework.event.player;

import no.runsafe.framework.server.event.player.RunsafePlayerTeleportEvent;
import no.runsafe.framework.event.IRunsafeEvent;

public interface IPlayerTeleportEvent extends IRunsafeEvent
{
	public void OnPlayerTeleport(RunsafePlayerTeleportEvent event);
}
