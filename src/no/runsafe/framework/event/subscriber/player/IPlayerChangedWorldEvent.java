package no.runsafe.framework.event.subscriber.player;

import no.runsafe.framework.event.subscriber.IRunsafeEvent;
import no.runsafe.framework.player.RunsafePlayer;
import no.runsafe.framework.world.RunsafeWorld;

public interface IPlayerChangedWorldEvent extends IRunsafeEvent
{
	public void OnPlayerChangedWorld(RunsafePlayer player, RunsafeWorld fromWorld);
}
