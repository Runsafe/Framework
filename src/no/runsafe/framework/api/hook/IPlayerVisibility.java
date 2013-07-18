package no.runsafe.framework.api.hook;

import no.runsafe.framework.minecraft.player.RunsafePlayer;

public interface IPlayerVisibility extends IFrameworkHook
{
	/**
	 * Called by {@link RunsafePlayer#shouldNotSee(RunsafePlayer)} to test if a player should be aware of someone else or not
	 */
	boolean isPlayerHidden(RunsafePlayer viewer, RunsafePlayer target);

	/**
	 * Called by {@link RunsafePlayer#isVanished()} to test if a player has vanished or not
	 */
	boolean isPlayerVanished(RunsafePlayer player);
}
