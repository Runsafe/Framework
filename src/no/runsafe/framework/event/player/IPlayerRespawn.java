package no.runsafe.framework.event.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerRespawn extends IRunsafeEvent
{
	RunsafeLocation OnPlayerRespawn(RunsafePlayer player, RunsafeLocation location, boolean isBed);
}
