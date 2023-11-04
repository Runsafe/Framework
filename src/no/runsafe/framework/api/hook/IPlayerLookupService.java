package no.runsafe.framework.api.hook;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public interface IPlayerLookupService extends IFrameworkHook
{
	/**
	 * Called to autocomplete partial names
	 */
	List<String> findPlayer(String lookup);

	/**
	 * Looks up the UUID of the player who logged the most recently with a specified username.
	 *
	 * @param playerName Exact name of the player to lookup.
	 * @return the UUID of the last player to loged in.
	 *         Null if the player can't be found.
	 */
	@Nullable
	UUID findPlayerUniqueId(String playerName);

	/**
	 * Gets the most recent username a player has logged in with.
	 *
	 * @param playerId The player's identifying number.
	 * @return The latest username a player has logged in with.
	 *         Might not be the player's current username.
	 *         Null if the player has never logged into the server.
	 */
	@Nullable
	String getLatestUsername(UUID playerId);
}
