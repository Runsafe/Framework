package no.runsafe.framework.hook;

import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerPvPFlag extends FrameworkHook
{
	/**
	 * Called by {@link no.runsafe.framework.server.player.RunsafePlayer#isPvPFlagged()} for plugins controlling pvp actions
	 */
	boolean isFlaggedForPvP(RunsafePlayer player);
}
