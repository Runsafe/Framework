package no.runsafe.framework.player.event;

import no.runsafe.framework.player.RunsafePlayer;
import no.runsafe.framework.world.RunsafeWorld;

public interface IPlayerChangedWorldEvent 
{
	public void OnPlayerChangedWorld(RunsafePlayer player, RunsafeWorld fromWorld, RunsafeWorld toWorld);
}
