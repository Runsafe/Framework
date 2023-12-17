package no.runsafe.framework.api.hook;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.extension.player.RunsafePlayer;

public interface IPlayerBuildPermission extends IFrameworkHook
{
	/**
	 * Called by {@link RunsafePlayer#canBuildNow()} on behalf of plugins that
	 * want to find out if the player can build or not
	 */
	boolean blockPlayerBuilding(IPlayer player, ILocation location);
}
