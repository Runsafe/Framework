package no.runsafe.framework.api.event.player;

import no.runsafe.framework.minecraft.player.RunsafePlayer;

public interface IPlayerCustomEvent
{
	public void OnPlayerCustomEvent(RunsafePlayer player, String event, Object data);
}
