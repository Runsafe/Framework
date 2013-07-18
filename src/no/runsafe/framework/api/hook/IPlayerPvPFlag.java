package no.runsafe.framework.api.hook;

import no.runsafe.framework.minecraft.player.RunsafePlayer;

public interface IPlayerPvPFlag extends IFrameworkHook
{
	/**
	 * Called by {@link RunsafePlayer#isPvPFlagged()} for plugins controlling pvp actions
	 */
	boolean isPvPDisabled(RunsafePlayer player);
}
