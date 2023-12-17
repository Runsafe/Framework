package no.runsafe.framework.api.server;

import no.runsafe.framework.api.player.IPlayer;

import java.util.List;

public interface IWhitelistManager
{
	List<IPlayer> getWhitelistedPlayers();

	boolean hasWhitelist();

	void reloadWhitelist();

	void setWhitelist(boolean value);
}
