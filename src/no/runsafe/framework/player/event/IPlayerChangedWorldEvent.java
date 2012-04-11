package no.runsafe.framework.player.event;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.player.RunsafePlayer;
import no.runsafe.framework.world.RunsafeWorld;

public interface IPlayerChangedWorldEvent extends IRunsafeEvent
{
	public void OnPlayerChangedWorld(RunsafePlayer player, RunsafeWorld fromWorld);
}
