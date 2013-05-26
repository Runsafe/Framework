package no.runsafe.framework.event.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerTeleport extends IRunsafeEvent
{
	public boolean OnPlayerTeleport(RunsafePlayer player, RunsafeLocation from, RunsafeLocation to);
}
