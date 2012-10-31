package no.runsafe.framework.event.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerClickEvent;

@Deprecated
public interface IPlayerRightClickEvent extends IRunsafeEvent
{
	void OnPlayerRightClick(RunsafePlayerClickEvent event);
}
