package no.runsafe.framework.hook;

import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerSystemBroadcast extends FrameworkHook
{
	void sendPlayerSystemBroadcast(RunsafePlayer player, String message);
}
