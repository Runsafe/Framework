package no.runsafe.framework.event.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerDeathEvent;

public interface IPlayerDeathEvent extends IRunsafeEvent
{
	public void OnPlayerDeathEvent(RunsafePlayerDeathEvent event);
}
