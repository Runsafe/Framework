package no.runsafe.framework.event.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerMove extends IRunsafeEvent
{
	boolean OnPlayerMove(RunsafePlayer player, RunsafeLocation from, RunsafeLocation to);
}
