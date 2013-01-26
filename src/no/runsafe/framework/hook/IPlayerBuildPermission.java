package no.runsafe.framework.hook;

import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.player.RunsafePlayer;

public interface IPlayerBuildPermission extends FrameworkHook
{
	/**
	 * Called by {@link no.runsafe.framework.server.player.RunsafePlayer#canBuildNow()} on behalf of plugins that
	 * want to find out if the player can build or not
	 */
	boolean blockPlayerBuilding(RunsafePlayer player, RunsafeLocation location);
}
