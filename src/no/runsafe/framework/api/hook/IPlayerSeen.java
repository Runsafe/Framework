package no.runsafe.framework.api.hook;

import no.runsafe.framework.minecraft.player.RunsafePlayer;

public interface IPlayerSeen extends IFrameworkHook
{
	/**
	 * Called by {@link no.runsafe.framework.minecraft.player.RunsafePlayer#getLastSeen(no.runsafe.framework.minecraft.player.RunsafePlayer)} to get their last seen time.
	 */
	String GetLastSeen(RunsafePlayer player, RunsafePlayer checker);
}
