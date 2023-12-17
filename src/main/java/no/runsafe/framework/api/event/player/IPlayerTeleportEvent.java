package no.runsafe.framework.api.event.player;

import no.runsafe.framework.minecraft.event.player.RunsafePlayerTeleportEvent;
import no.runsafe.framework.api.event.IRunsafeEvent;

public interface IPlayerTeleportEvent extends IRunsafeEvent
{
	void OnPlayerTeleport(RunsafePlayerTeleportEvent event);
}
