package no.runsafe.framework.hook;

import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerVisibility extends FrameworkHook
{
	/**
	 * Called by {@link no.runsafe.framework.server.player.RunsafePlayer#canSee(no.runsafe.framework.server.player.RunsafePlayer)} to test if a player should be aware of someone else or not
	 */
	boolean canPlayerASeeB(RunsafePlayer a, RunsafePlayer b);

	/**
	 * Called by {@link no.runsafe.framework.server.player.RunsafePlayer#isVanished()} to test if a player has vanished or not
	 */
	boolean isPlayerVanished(RunsafePlayer player);
}
