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
	 * Looks up the Unique Id of the player who logged the most recently with a specified username.
	 *
	 * @param playerName Exact name of the player to lookup.
	 * @return the UUID of the last player to loged in.
	 *         Null if the player can't be found.
	 */
	@Nullable
	UUID findPlayerUniqueId(String playerName);
}
