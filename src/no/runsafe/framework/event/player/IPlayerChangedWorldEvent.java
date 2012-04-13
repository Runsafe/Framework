package no.runsafe.framework.event.player;

import no.runsafe.framework.server.event.player.RunsafePlayerChangedWorldEvent;
import no.runsafe.framework.event.IRunsafeEvent;

public interface IPlayerChangedWorldEvent extends IRunsafeEvent
{
	public void OnPlayerChangedWorld(RunsafePlayerChangedWorldEvent event);
}
