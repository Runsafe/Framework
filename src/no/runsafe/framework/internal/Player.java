package no.runsafe.framework.internal;

import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.player.IPlayer;
import org.picocontainer.Startable;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings("StaticVariableUsedBeforeInitialization")
public class Player
{
	public static IPlayer getExact(String name)
	{
		return server.getOfflinePlayerExact(name);
	}

	public static List<String> getOnline(IPlayer context, String filter)
	{
		return server.getOnlinePlayers(context, filter);
	}

	public static void setKicker(String name, IPlayer kicker)
	{
		if (kickingPlayer.containsKey(name))
			kickingPlayer.replace(name, kicker);
		else
			kickingPlayer.put(name, kicker);
	}

	@Nullable
	public static IPlayer getKicker(String playerName)
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

	@SuppressWarnings("NonThreadSafeLazyInitialization")
	public Player(IServer server)
	{
		if (Player.server == null)
			Player.server = server;
	}

	private static IServer server;
	private static final ConcurrentHashMap<String, IPlayer> kickingPlayer = new ConcurrentHashMap<String, IPlayer>();
}
