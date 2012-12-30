package no.runsafe.framework.event.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerKickEvent;

public interface IPlayerKickEvent extends IRunsafeEvent
{
	public void OnPlayerKick(RunsafePlayerKickEvent event);
}
