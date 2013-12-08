package no.runsafe.framework.minecraft;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import no.runsafe.framework.api.IDebug;
import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.hook.IPlayerLookupService;
import no.runsafe.framework.api.hook.IPlayerPermissions;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.Debug;
import no.runsafe.framework.internal.HookEngine;
import no.runsafe.framework.internal.wrapper.BukkitServer;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.player.RunsafeAmbiguousPlayer;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RunsafeServer extends BukkitServer implements IServer
{
	@Deprecated
	/**
	 * Entrypoint for internal framework usage only.
	 * Use injection to get IServer from plugins!
	 */
	public static IServer InternalAPI;

	public RunsafeServer(Server toWrap)
	{
		super(toWrap);
		debugger = new Debug();
	}

	@Deprecated
	@Override
	public IDebug getDebugger()
	{
		return debugger;
	}

	public static List<String> getGroups()
	{
		List<IPlayerPermissions> hooks = HookEngine.hookContainer.getComponents(IPlayerPermissions.class);
		if (hooks == null)
			return Lists.newArrayList();

		List<String> groups = new ArrayList<String>(hooks.size() * 5);
		for (IPlayerPermissions hook : hooks)
		{
			List<String> hookGroups = hook.getGroups();
			if (hookGroups != null)
				groups.addAll(hookGroups);
		}
		return groups;
	}

	@Override
	@Nullable
	public IPlayer getPlayer(String playerName)
	{
		if (playerName == null)
			return null;

		Player rawPlayer = server.getPlayerExact(playerName);
		if (rawPlayer != null && rawPlayer.isOnline())
			return ObjectWrapper.convert((OfflinePlayer) rawPlayer);

		List<String> hits = findPlayer(playerName);

		if (hits.isEmpty())
			return null;

		if (hits.size() == 1)
			return new RunsafePlayer(server.getOfflinePlayer(hits.get(0)));

		return new RunsafeAmbiguousPlayer(server.getOfflinePlayer(hits.get(0)), hits);
	}

	@Override
	@Nullable
	public IPlayer getOnlinePlayer(IPlayer context, String playerName)
	{
		if (playerName == null)
			return null;

		Player exact = server.getPlayerExact(playerName);
		if (exact != null && exact.isOnline())
			return new RunsafePlayer(exact);

		List<IPlayer> online = filterPlayers(context, getOnlinePlayers(playerName));
		if (online == null || online.isEmpty())
			return null;

		if (online.size() == 1)
			return online.get(0);

		return new RunsafeAmbiguousPlayer(online);
	}

	@Override
	@Nullable
	public List<IPlayer> getOnlinePlayers(String playerName)
	{
		if (playerName == null)
			return null;

		playerName = playerName.toLowerCase();
		List<OfflinePlayer> players = new ArrayList<OfflinePlayer>(server.getOnlinePlayers().length);
		for (OfflinePlayer player : server.getOnlinePlayers())
			if (player.getName().toLowerCase().startsWith(playerName))
				players.add(player);

		return ObjectWrapper.convert(players);
	}

	@Override
	@Nullable
	public IPlayer getPlayerExact(String playerName)
	{
		if (playerName == null)
			return null;

		Player player = server.getPlayerExact(playerName);
		if (player == null)
		{
			List<String> players = findPlayer(playerName);
			return players.contains(playerName) ? new RunsafePlayer(server.getOfflinePlayer(playerName)) : null;
		}
		return new RunsafePlayer(player);
	}

	@SuppressWarnings("MethodWithMultipleLoops")
	@Nonnull
	public static List<String> findPlayer(String playerName)
	{
		if (playerName == null || playerName.isEmpty())
			return ImmutableList.of();

		List<String> hits = new ArrayList<String>(1);
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

	public static List<IPlayer> filterPlayers(IPlayer context, List<IPlayer> players)
	{
		if (context == null || players == null)
			return players;

		List<IPlayer> filtered = new ArrayList<IPlayer>(players.size());
		for (IPlayer player : players)
			if (context.shouldNotSee(player))
				filtered.add(player);
		filtered.removeAll(filtered);
		return filtered;
	}

	@Override
	public void banPlayer(IPlayer banner, IPlayer player, String reason)
	{
		if (player == null)
			return;

		if (banner != null)
			kickingPlayer.put(player.getName(), banner);
		player.setBanned(true);
		player.kick(reason);
	}

	@Override
	public void kickPlayer(IPlayer kicker, IPlayer player, String reason)
	{
		if (player == null)
			return;
		if (kicker != null)
			kickingPlayer.put(player.getName(), kicker);
		player.kick(reason);
	}

	@Override
	@SuppressWarnings("LocalVariableOfConcreteClass")
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

	@Override
	public boolean someoneHasPermission(String permission)
	{
		if (permission == null || permission.isEmpty())
			return false;
		for (Player player : server.getOnlinePlayers())
			if (player.hasPermission(permission))
				return true;
		return false;
	}

	@Override
	public List<IPlayer> getPlayersWithPermission(String permission)
	{
		if (permission == null || permission.isEmpty())
			return Lists.newArrayList();

		List<IPlayer> results = new ArrayList<IPlayer>(server.getOnlinePlayers().length);
		for (Player player : server.getOnlinePlayers())
			if (player.hasPermission(permission))
				results.add(ObjectWrapper.convert((OfflinePlayer) player));
		return results;
	}

	@Override
	@SuppressWarnings("unchecked")
	@Nullable
	public <T extends Plugin> T getPlugin(String pluginName)
	{
		if (pluginName == null || pluginName.isEmpty())
			return null;
		Plugin plugin = server.getPluginManager().getPlugin(pluginName);
		if (plugin == null)
			return null;
		return (T) plugin;
	}

	private final ConcurrentHashMap<String, IPlayer> kickingPlayer = new ConcurrentHashMap<String, IPlayer>();
	private final IDebug debugger;

	@Override
	public List<String> getOnlinePlayers(IPlayer context, String playerName)
	{
		List<IPlayer> matches = playerName == null || playerName.isEmpty() ? getOnlinePlayers() : matchPlayer(playerName);
		if (matches == null || matches.isEmpty())
			return Lists.newArrayList();

		List<String> players = new ArrayList<String>(matches.size());
		for (IPlayer player : matches)
		{
			if (context.shouldNotSee(player))
				continue;
			players.add(player.getName());
		}
		return players;
	}
}
