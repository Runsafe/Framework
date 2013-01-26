package no.runsafe.framework.hook;

import no.runsafe.framework.server.player.RunsafePlayer;
import org.joda.time.DateTime;

import java.util.HashMap;

public interface IPlayerDataProvider extends FrameworkHook
{
	/**
	 * Called by {@link no.runsafe.framework.server.player.RunsafePlayer#getData()} on behalf of plugins that
	 * want to find out various data about a player
	 */
	HashMap<String, String> GetPlayerData(RunsafePlayer player);

	/**
	 * Called by {@link no.runsafe.framework.server.player.RunsafePlayer#lastLogout()} on behalf of plugins that
	 * want to find out when a player left the server
	 */
	DateTime GetPlayerLogout(RunsafePlayer player);

	/**
	 * Called by {@link no.runsafe.framework.server.player.RunsafePlayer#getBanReason()} on behalf of plugins that
	 * want to know why a player was banned
	 */
	String GetPlayerBanReason(RunsafePlayer player);
}
