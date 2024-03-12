package no.runsafe.framework.api.server;

import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public interface IPlayerProvider
{
	/***
	 * @deprecated Use getOfflinePlayerExact or getPlayerExact
	 * @param playerName the name of the player
	 * @return the player object
	 */
	@Nullable
	@Deprecated
	IPlayer getPlayer(String playerName);

	@Nullable
	IPlayer getPlayer(UUID playerUUID);

	@Nullable
	IPlayer getOnlinePlayer(IPlayer context, String playerName);

	@Nullable
	List<IPlayer> getOnlinePlayers(String playerName);

	@Nullable
	List<String> getOnlinePlayerNames(String playerName);

	@Nullable
	IPlayer getPlayerExact(String playerName);

	@Nullable
	List<IPlayer> matchPlayer(String playerName);

	@Nullable
	IPlayer getOfflinePlayerExact(String playerName);

	List<IPlayer> getOfflinePlayers();

	List<IPlayer> getOnlinePlayers();

	List<String> getOnlinePlayers(IPlayer context, String playerName);

	List<IPlayer> getPlayersByIDs(Iterable<String> playerStringIds);
}
