package no.runsafe.framework.event.player;

import no.runsafe.framework.server.event.player.RunsafePlayerQuitEvent;
import no.runsafe.framework.event.IRunsafeEvent;

public interface IPlayerQuitEvent extends IRunsafeEvent
{
	public void OnPlayerQuit(RunsafePlayerQuitEvent event);
}
