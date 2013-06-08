package no.runsafe.framework.server;

import no.runsafe.framework.hook.HookEngine;
import no.runsafe.framework.hook.IPlayerLookupService;
import no.runsafe.framework.server.player.RunsafeAmbiguousPlayer;
import no.runsafe.framework.server.player.RunsafePlayer;
import no.runsafe.framework.wrapper.BukkitServer;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RunsafeServer extends BukkitServer
{
	public static RunsafeServer Instance = null;

	public RunsafeServer(Server toWrap)
	{
		super(toWrap);
	}

	public RunsafePlayer getPlayer(String playerName)
	{
		if (playerName == null)
			return null;

		Player rawPlayer = server.getPlayerExact(playerName);
		if (rawPlayer != null && rawPlayer.isOnline())
			return ObjectWrapper.convert(rawPlayer);

		List<String> hits = findPlayer(playerName);

		if (hits.size() == 0)
			return null;

		if (hits.size() == 1)
			return new RunsafePlayer(server.getOfflinePlayer(hits.get(0)));

		return new RunsafeAmbiguousPlayer(server.getOfflinePlayer(hits.get(0)), hits);
	}

	public RunsafePlayer getOnlinePlayer(RunsafePlayer context, String playerName)
	{
		if (playerName == null)
			return null;

		Player exact = server.getPlayerExact(playerName);
		if (exact != null && exact.isOnline())
			return new RunsafePlayer(exact);

		List<RunsafePlayer> online = filterPlayers(context, getOnlinePlayers(playerName));
		if (online == null || online.isEmpty())
			return null;

		if (online.size() == 1)
			return online.get(0);

		return new RunsafeAmbiguousPlayer(online);
	}

	public List<RunsafePlayer> getOnlinePlayers(String playerName)
	{
		playerName = playerName.toLowerCase();
		List<OfflinePlayer> players = new ArrayList<OfflinePlayer>();
		for (OfflinePlayer player : server.getOnlinePlayers())
			if (player.getName().toLowerCase().startsWith(playerName))
				players.add(player);
		return ObjectWrapper.convert(players);
	}

	public RunsafePlayer getPlayerExact(String playerName)
	{
		if (playerName == null)
			return null;

		Player player = this.server.getPlayerExact(playerName);
		if (player == null)
		{
			List<String> players = findPlayer(playerName);
			return players.contains(playerName) ? new RunsafePlayer(server.getOfflinePlayer(playerName)) : null;
		}
		return new RunsafePlayer(player);
	}

	public List<String> findPlayer(String playerName)
	{
		ArrayList<String> hits = new ArrayList<String>();
		for (IPlayerLookupService lookup : HookEngine.hookContainer.getComponents(IPlayerLookupService.class))
		{
			List<String> data = lookup.findPlayer(playerName);
			if (data != null)
			{
				// Exact match, prefer this to anything else
				if (data.contains(playerName))
				{
					hits.clear();
					hits.add(playerName);
					break;
				}
				// Add hits to result list
				for (String hit : data)
					if (!hits.contains(hit))
						hits.add(hit);
			}
		}
		return hits;
	}

	public List<RunsafePlayer> filterPlayers(RunsafePlayer context, List<RunsafePlayer> players)
	{
		if (context == null || players == null)
			return players;

		List<RunsafePlayer> filtered = new ArrayList<RunsafePlayer>();
		for (RunsafePlayer player : players)
			if (!context.canSee(player))
				filtered.add(player);
		filtered.removeAll(filtered);
		return filtered;
	}

	public void banPlayer(RunsafePlayer banner, RunsafePlayer player, String reason)
	{
		kickingPlayer.put(player.getName(), banner);
		player.setBanned(true);
		player.kick(reason);
	}

	public void kickPlayer(RunsafePlayer kicker, RunsafePlayer player, String reason)
	{
		if (kicker != null)
			kickingPlayer.put(player.getName(), kicker);
		player.kick(reason);
	}

	public RunsafePlayer getKicker(String playerName)
	{
		if (kickingPlayer.containsKey(playerName))
		{
			RunsafePlayer kicker = kickingPlayer.get(playerName);
			kickingPlayer.remove(playerName);
			return kicker;
		}
		return null;
	}

	public boolean someoneHasPermission(String permission)
	{
		for (Player player : server.getOnlinePlayers())
			if (player.hasPermission(permission))
				return true;
		return false;
	}

	public List<RunsafePlayer> getPlayersWithPermission(String permission)
	{
		ArrayList<RunsafePlayer> results = new ArrayList<RunsafePlayer>();
		for (Player player : server.getOnlinePlayers())
			if (player.hasPermission(permission))
				results.add(ObjectWrapper.convert(player));
		return results;
	}

	@SuppressWarnings("unchecked")
	public <T extends Plugin> T getPlugin(String pluginName)
	{
		Plugin plugin = server.getPluginManager().getPlugin(pluginName);
		if (plugin == null)
			return null;
		return (T) plugin;
	}

	private final ConcurrentHashMap<String, RunsafePlayer> kickingPlayer = new ConcurrentHashMap<String, RunsafePlayer>();
}
