package no.runsafe.framework.api.hook;

import no.runsafe.framework.minecraft.player.RunsafePlayer;

public interface IPlayerSystemBroadcast extends IFrameworkHook
{
	void sendPlayerSystemBroadcast(RunsafePlayer player, String message);
}
