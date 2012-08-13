package no.runsafe.framework.event.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerClickEvent;

public interface IPlayerLeftClickEvent extends IRunsafeEvent
{
	void OnPlayerLeftClick(RunsafePlayerClickEvent event);
}
