package no.runsafe.framework.internal;

import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.player.IPlayer;

import javax.annotation.Nullable;
import java.util.List;
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

	public List<String> getOnline(IPlayer context, String filter)
	{
		return server.getOnlinePlayers(context, filter);
	}

	public List<String> getOnline(String value)
	{
		return server.getOnlinePlayerNames(value);
	}

	public void setKicker(String name, IPlayer kicker)
	{
		if (kickingPlayer.containsKey(name))
			kickingPlayer.replace(name, kicker);
		else
			kickingPlayer.put(name, kicker);
	}

	@Nullable
	public IPlayer getKicker(String playerName)
	{
		if (playerName == null || playerName.isEmpty())
			return null;
		if (kickingPlayer.containsKey(playerName))
		{
			IPlayer kicker = kickingPlayer.get(playerName);
			kickingPlayer.remove(playerName);
			return kicker;
		}
		return null;
	}

	private final IServer server;
	private final ConcurrentHashMap<String, IPlayer> kickingPlayer = new ConcurrentHashMap<String, IPlayer>();
}
