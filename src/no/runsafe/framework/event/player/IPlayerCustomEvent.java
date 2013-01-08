package no.runsafe.framework.event.player;

import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerCustomEvent
{
	public void OnPlayerCustomEvent(RunsafePlayer player, String event, Object data);
}
