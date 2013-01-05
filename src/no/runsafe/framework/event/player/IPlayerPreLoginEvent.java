package no.runsafe.framework.event.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerPreLoginEvent;

public interface IPlayerPreLoginEvent extends IRunsafeEvent
{
	void OnBeforePlayerLogin(RunsafePlayerPreLoginEvent event);
}
