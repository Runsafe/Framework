package no.runsafe.framework.api.hook;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.extension.player.RunsafePlayer;

public interface IPlayerVisibility extends IFrameworkHook
{
	/**
	 * Called by {@link RunsafePlayer#shouldNotSee(no.runsafe.framework.api.player.IPlayer)} to test if a player should be aware of someone else or not
	 */
	boolean isPlayerHidden(IPlayer viewer, IPlayer target);

	/**
	 * Called by {@link RunsafePlayer#isVanished()} to test if a player has vanished or not
	 */
	boolean isPlayerVanished(IPlayer player);
}
