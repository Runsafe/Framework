package no.runsafe.framework.api.server;

import no.runsafe.framework.api.player.IPlayer;

import java.util.List;
import java.util.Set;

public interface IPlayerManager
{
	List<IPlayer> getBannedPlayers();

	void banPlayer(IPlayer banner, IPlayer player, String reason);

	void unbanPlayer(IPlayer player);

	void kickPlayer(IPlayer kicker, IPlayer player, String reason);

	void banIP(String address);

	Set<String> getIpBans();

	void unbanIP(String ip);
}
