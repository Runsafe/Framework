package no.runsafe.framework.api.hook;

import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public interface IPlayerBuildPermission extends IFrameworkHook
{
	/**
	 * Called by {@link RunsafePlayer#canBuildNow()} on behalf of plugins that
	 * want to find out if the player can build or not
	 */
	boolean blockPlayerBuilding(RunsafePlayer player, RunsafeLocation location);
}
