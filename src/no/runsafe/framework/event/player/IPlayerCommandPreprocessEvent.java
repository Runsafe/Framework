package no.runsafe.framework.event.player;

import no.runsafe.framework.server.event.player.RunsafePlayerCommandPreprocessEvent;
import no.runsafe.framework.event.IRunsafeEvent;

public interface IPlayerCommandPreprocessEvent extends IRunsafeEvent
{
	public void OnBeforePlayerCommand(RunsafePlayerCommandPreprocessEvent event);
}
