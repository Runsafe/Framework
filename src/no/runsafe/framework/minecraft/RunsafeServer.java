package no.runsafe.framework.minecraft;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.IDebug;
import no.runsafe.framework.api.hook.IPlayerLookupService;
import no.runsafe.framework.api.hook.IPlayerPermissions;
import no.runsafe.framework.internal.Debugger;
import no.runsafe.framework.internal.HookEngine;
import no.runsafe.framework.internal.wrapper.BukkitServer;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.player.RunsafeAmbiguousPlayer;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
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
		debugger = new Debugger(toWrap.getLogger());
	}

	public IDebug getDebugger()
	{
		return debugger;
	}

	public List<String> getGroups()
	{
		List<IPlayerPermissions> hooks = HookEngine.hookContainer.getComponents(IPlayerPermissions.class);
		List<String> groups = new ArrayList<String>();
		if (hooks != null)
		{
			for (IPlayerPermissions hook : hooks)
			{
				List<String> hookGroups = hook.getGroups();
				if (hookGroups != null)
					groups.addAll(hookGroups);
			}
		}
		return groups;
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
		if (playerName == null)
			return null;

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
		if (playerName == null || playerName.isEmpty())
			return null;

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
			if (context.shouldNotSee(player))
				filtered.add(player);
		filtered.removeAll(filtered);
		return filtered;
	}

	public void banPlayer(RunsafePlayer banner, RunsafePlayer player, String reason)
	{
		if (player == null)
			return;

		if (banner != null)
			kickingPlayer.put(player.getName(), banner);
		player.setBanned(true);
		player.kick(reason);
	}

	public void kickPlayer(RunsafePlayer kicker, RunsafePlayer player, String reason)
	{
		if (player == null)
			return;
		if (kicker != null)
			kickingPlayer.put(player.getName(), kicker);
		player.kick(reason);
	}

	public RunsafePlayer getKicker(String playerName)
	{
		if (playerName == null || playerName.isEmpty())
			return null;
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
		if (permission == null || permission.isEmpty())
			return false;
		for (Player player : server.getOnlinePlayers())
			if (player.hasPermission(permission))
				return true;
		return false;
	}

	public List<RunsafePlayer> getPlayersWithPermission(String permission)
	{
		if (permission == null || permission.isEmpty())
			return Lists.newArrayList();

		ArrayList<RunsafePlayer> results = new ArrayList<RunsafePlayer>();
		for (Player player : server.getOnlinePlayers())
			if (player.hasPermission(permission))
				results.add(ObjectWrapper.convert(player));
		return results;
	}

	@SuppressWarnings("unchecked")
	public <T extends Plugin> T getPlugin(String pluginName)
	{
		if (pluginName == null || pluginName.isEmpty())
			return null;
		Plugin plugin = server.getPluginManager().getPlugin(pluginName);
		if (plugin == null)
			return null;
		return (T) plugin;
	}

	private final ConcurrentHashMap<String, RunsafePlayer> kickingPlayer = new ConcurrentHashMap<String, RunsafePlayer>();
	private final Debugger debugger;

	public List<String> getOnlinePlayers(RunsafePlayer context, String playerName)
	{
		List<RunsafePlayer> matches = matchPlayer(playerName);
		if(matches == null || matches.isEmpty())
			return Lists.newArrayList();

		List<String> players = new ArrayList<String>();
		for(RunsafePlayer player : matches)
		{
			if(context.shouldNotSee(player))
				continue;
			players.add(player.getName());
		}
		return players;
	}
}
