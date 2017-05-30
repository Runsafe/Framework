package no.runsafe.framework.internal.extension;

import com.google.common.collect.Lists;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.hook.IPlayerExtensions;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.log.Console;
import no.runsafe.framework.internal.wrapper.BukkitServer;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.internal.extension.player.RunsafeAmbiguousPlayer;
import no.runsafe.framework.internal.extension.player.RunsafePlayer;
import no.runsafe.framework.timer.Scheduler;
import org.bukkit.BanList;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class RunsafeServer extends BukkitServer implements IServer
{
	public RunsafeServer(Server toWrap)
	{
		super(toWrap);
	}

	public IScheduler getScheduler()
	{
		return new Scheduler(server.getScheduler(), null, Console.Global());
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
	public IPlayer getPlayer(UUID playerUUID)
	{
		if (playerUUID == null)
			return null;

		Player rawPlayer = server.getPlayer(playerUUID);

		if (rawPlayer != null && rawPlayer.isOnline())
			return ObjectWrapper.convert((OfflinePlayer) rawPlayer);

		return ObjectWrapper.convert(server.getOfflinePlayer(playerUUID));
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

		String lookup = playerName.toLowerCase();
		List<OfflinePlayer> players = new ArrayList<OfflinePlayer>(server.getOnlinePlayers().size());
		for (OfflinePlayer player : server.getOnlinePlayers())
			if (player.getName().toLowerCase().startsWith(lookup))
				players.add(player);

		return ObjectWrapper.convert(players);
	}

	@Override
	@Nullable
	public List<String> getOnlinePlayerNames(String playerName)
	{
		if (playerName == null)
			return null;

		String lookup = playerName.toLowerCase();
		List<String> players = new ArrayList<String>(server.getOnlinePlayers().size());
		for (OfflinePlayer player : server.getOnlinePlayers())
			if (player.getName().toLowerCase().startsWith(lookup))
				players.add(player.getName());

		return players;
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

	@Nonnull
	public static List<String> findPlayer(String playerName)
	{
		return InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).find(playerName);
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

		String bannerName = "Unknown";
		if (banner != null)
		{
			no.runsafe.framework.internal.Player.Get().setKicker(player, banner);
			bannerName = banner.getName();
		}
		server.getBanList(BanList.Type.NAME).addBan(player.getName(), reason, null, bannerName);
		player.kick(reason);
	}

	@Override
	public void unbanPlayer(IPlayer player)
	{
		if(player == null)
			return;

		server.getBanList(BanList.Type.NAME).pardon(player.getName());
	}

	@Override
	public void kickPlayer(IPlayer kicker, IPlayer player, String reason)
	{
		if (player == null)
			return;
		if (kicker != null)
			no.runsafe.framework.internal.Player.Get().setKicker(player, kicker);
		player.kick(reason);
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

		List<IPlayer> results = new ArrayList<IPlayer>(server.getOnlinePlayers().size());
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

	/**
	 * Converts a list of IPlayers into a list of their usernames.
	 *
	 * @param players List of players.
	 *                If a player is null, they will be skipped.
	 *                If a player's username is null or empty, "Invalid Username"
	 *                will be used instead.
	 *
	 * @return List of player usernames.
	 */
	@Override
	public List<String> getUsernames(List<IPlayer> players)
	{
		if (players == null || players.isEmpty())
			return Collections.emptyList();

		List<String> playerNames = new ArrayList<>(players.size());
		for(IPlayer player : players)
		{
			if (player == null)
				continue;
			String playerName = player.getName();
			if (playerName == null || playerName.isEmpty())
				playerNames.add("Invalid Player");
			else
				playerNames.add(playerName);
		}
		return playerNames;
	}

	/**
	 * Converts a list of UUIDs into IPlayers.
	 *
	 * @param playerIds List of player UUIDs.
	 *                  For every null UUID a null player will put on the list.
	 *                  When not null, assumed to be valid player Ids.
	 *
	 * @return List of IPlayers.
	 */
	@Override
	public List<IPlayer> getPlayersFromUniqueIds(List<UUID> playerIds)
	{
		if (playerIds == null || playerIds.isEmpty())
			return Collections.emptyList();

		List<IPlayer> players = new ArrayList<>(playerIds.size());
		for(UUID playerId : playerIds)
		{
			if (playerId == null)
				continue;
			players.add(this.getPlayer(playerId));
		}
		return players;
	}

	/**
	 * Converts a list of UUIDs in the form of strings into IPlayers.
	 *
	 * @param playerIds List of player UUIDs in the form of strings.
	 *                  Prefferably obtained through UUID's toString method.
	 *                  For every null or non 36 length strings a null player
	 *                  will put on the list.
	 *                  When they are valid UUIDs, assumed to be player Ids.
	 *
	 * @return List of IPlayers.
	 *
	 * @throws  IllegalArgumentException
	 *          If any string in the list of playerIds is 36 in length
	 *          and is not a valid UUID returned by the UUID toString method.
	 */
	@Override
	public List<IPlayer> getPlayersFromUniqueIdStrings(List<String> playerIds)
	{
		if (playerIds == null || playerIds.isEmpty())
			return Collections.emptyList();

		List<IPlayer> players = new ArrayList<>(playerIds.size());
		for(String playerId : playerIds)
		{
			if (playerId == null || playerId.length() != 36)
				continue;
			players.add(this.getPlayer(UUID.fromString(playerId)));
		}
		return players;
	}

	@Override
	public void addRecipe(ShapedRecipe recipe)
	{
		server.addRecipe(recipe);
	}
}
