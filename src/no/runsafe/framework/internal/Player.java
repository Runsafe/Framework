package no.runsafe.framework.internal;

import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class Player
{
	public static Player Get()
	{
		return InjectionPlugin.getGlobalComponent(Player.class);
	}

	public Player(IServer server)
	{
		this.server = server;
	}

	public IPlayer getExact(String name)
	{
		return server.getOfflinePlayerExact(name);
	}

	public IPlayer getExact(UUID uniqueId)
	{
		return server.getPlayer(uniqueId);
	}

	public List<String> getOnline(IPlayer context, String filter)
	{
		return server.getOnlinePlayers(context, filter);
	}

	public List<String> getOnline(String value)
	{
		return server.getOnlinePlayerNames(value);
	}

	public void setKicker(IPlayer kickedPlayer, IPlayer kicker)
	{
		if (kickingPlayer.containsKey(kickedPlayer.getUniqueId()))
			kickingPlayer.replace(kickedPlayer.getUniqueId(), kicker);
		else
			kickingPlayer.put(kickedPlayer.getUniqueId(), kicker);
	}

	@Nullable
	public IPlayer getKicker(UUID playerId)
	{
		if (playerId == null)
			return null;
		if (kickingPlayer.containsKey(playerId))
		{
			IPlayer kicker = kickingPlayer.get(playerId);
			kickingPlayer.remove(playerId);
			return kicker;
		}
		return null;
	}

	private final IServer server;
	private final ConcurrentHashMap<UUID, IPlayer> kickingPlayer = new ConcurrentHashMap<>();
}
