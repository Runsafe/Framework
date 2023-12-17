package no.runsafe.framework.api.hook;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.extension.player.RunsafePlayer;
import org.joda.time.DateTime;

public interface IPlayerSessionDataProvider extends IFrameworkHook
{
	/**
	 * Called by {@link RunsafePlayer#lastLogout()} on behalf of plugins that
	 * want to find out when a player left the server
	 */
	DateTime GetPlayerLogout(IPlayer player);

	/**
	 * Called by {@link RunsafePlayer#getBanReason()} on behalf of plugins that
	 * want to know why a player was banned
	 */
	String GetPlayerBanReason(IPlayer player);

	/**
	 * Called by {@link RunsafePlayer#isNew()} on behalf of plugins that want to
	 * know if a player has connected for the first time
	 * Returning true asserts the user is new, false is unknown or not new
	 */
	boolean IsFirstSession(IPlayer player);
}
