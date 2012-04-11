package no.runsafe.framework.player.event;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.player.RunsafePlayer;

public interface IPlayerLoginEvent extends IRunsafeEvent
{
	public void OnPlayerLogin(RunsafePlayer player);
}
