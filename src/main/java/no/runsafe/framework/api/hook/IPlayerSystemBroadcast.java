package no.runsafe.framework.api.hook;

import no.runsafe.framework.api.player.IPlayer;

public interface IPlayerSystemBroadcast extends IFrameworkHook
{
	void sendPlayerSystemBroadcast(IPlayer player, String message);
}
