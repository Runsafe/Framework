package no.runsafe.framework.event.subscriber.player;

import no.runsafe.framework.event.subscriber.IRunsafeEvent;
import no.runsafe.framework.player.RunsafePlayer;

public interface IPlayerLoginEvent extends IRunsafeEvent
{
	public void OnPlayerLogin(RunsafePlayer player);
}
