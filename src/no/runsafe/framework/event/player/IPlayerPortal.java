package no.runsafe.framework.event.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerPortal extends IRunsafeEvent
{
	public boolean OnPlayerPortal(RunsafePlayer player, RunsafeLocation from, RunsafeLocation to);
}
