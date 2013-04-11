package no.runsafe.framework.event.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerRespawn extends IRunsafeEvent
{
	void OnPlayerRespawn(RunsafePlayer player);
}
