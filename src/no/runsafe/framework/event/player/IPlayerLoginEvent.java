package no.runsafe.framework.event.player;

import no.runsafe.framework.server.event.player.RunsafePlayerLoginEvent;
import no.runsafe.framework.event.IRunsafeEvent;

public interface IPlayerLoginEvent extends IRunsafeEvent
{
	public void OnPlayerLogin(RunsafePlayerLoginEvent event);
}
