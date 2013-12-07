package no.runsafe.framework.api.hook;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public interface IPlayerSeen extends IFrameworkHook
{
	/**
	 * Called by {@link RunsafePlayer#getLastSeen(no.runsafe.framework.api.player.IPlayer)} to get their last seen time.
	 */
	String GetLastSeen(IPlayer player, IPlayer checker);
}
