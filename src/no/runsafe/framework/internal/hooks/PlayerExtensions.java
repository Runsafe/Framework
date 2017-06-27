package no.runsafe.framework.internal.hooks;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import no.runsafe.framework.api.hook.*;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.extension.player.RunsafePlayer;
import no.runsafe.framework.minecraft.player.RunsafeFakePlayer;
import org.joda.time.DateTime;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SuppressWarnings("MethodWithMultipleLoops")
public final class PlayerExtensions implements IPlayerExtensions
{
	@Override
	@Nullable
	public String seen(RunsafePlayer player, IPlayer checker)
	{
		List<IPlayerSeen> seenHooks = getHooks(IPlayerSeen.class);
		if (!seenHooks.isEmpty())
			return seenHooks.get(0).GetLastSeen(player, checker);

		return null;
	}

	@Override
	public String decorate(IPlayer player)
	{
		String name = player.getName();
		for (IPlayerNameDecorator decorator : getHooks(IPlayerNameDecorator.class))
			name = decorator.DecorateName(player, name);
		return name;
	}

	@Override
	public boolean isNew(RunsafePlayer player)
	{
		List<IPlayerSessionDataProvider> dataHooks = getHooks(IPlayerSessionDataProvider.class);
		if (player.isOnline() || dataHooks.isEmpty())
			return false;

		for (IPlayerSessionDataProvider provider : dataHooks)
			if (provider.IsFirstSession(player))
				return true;

		return false;
	}

	@Override
	public Map<String, String> data(RunsafePlayer player)
	{
		Map<String, String> results = player.getBasicData();
		for (IPlayerDataProvider provider : getHooks(IPlayerDataProvider.class))
		{
			Map<String, String> data = provider.GetPlayerData(player);
			if (data != null)
				results.putAll(data);
		}
		return results;
	}

	@Override
	@Nullable
	public DateTime logout(RunsafePlayer player)
	{
		List<IPlayerSessionDataProvider> dataHooks = getHooks(IPlayerSessionDataProvider.class);
		if (player.isOnline() || dataHooks.isEmpty())
			return null;
		DateTime logout = null;
		for (IPlayerSessionDataProvider provider : dataHooks)
		{
			DateTime value = provider.GetPlayerLogout(player);
			if (value != null && (logout == null || value.isAfter(logout)))
				logout = value;
		}
		return logout;
	}

	@Override
	@Nullable
	public String banReason(RunsafePlayer player)
	{

		List<IPlayerSessionDataProvider> dataHooks = getHooks(IPlayerSessionDataProvider.class);
		if (player.isNotBanned() || dataHooks.isEmpty())
			return null;
		for (IPlayerSessionDataProvider provider : dataHooks)
		{
			String reason = provider.GetPlayerBanReason(player);
			if (reason != null)
				return reason;
		}
		return null;
	}

	@Override
	public boolean shouldNotSee(RunsafePlayer player, IPlayer target)
	{
		if (player.getName() == null || player.getName().equals(target.getName()))
			return false;

		List<IPlayerVisibility> visibilityHooks = getHooks(IPlayerVisibility.class);
		if (visibilityHooks.isEmpty())
			return false;

		for (IPlayerVisibility check : visibilityHooks)
			if (check.isPlayerHidden(player, target))
				return true;
		return false;
	}

	@Override
	public boolean isVanished(RunsafePlayer player)
	{
		List<IPlayerVisibility> visibilityHooks = getHooks(IPlayerVisibility.class);
		if (visibilityHooks.isEmpty())
			return false;
		for (IPlayerVisibility check : visibilityHooks)
			if (check.isPlayerVanished(player))
				return true;
		return false;
	}

	@Override
	public boolean isPvPFlagged(RunsafePlayer player)
	{
		List<IPlayerPvPFlag> pvpFlagHooks = getHooks(IPlayerPvPFlag.class);
		if (pvpFlagHooks.isEmpty())
			return true;
		for (IPlayerPvPFlag hook : pvpFlagHooks)
			if (hook.isPvPDisabled(player))
				return false;
		return true;
	}

	@Override
	public ImmutableList<String> getGroups(RunsafePlayer player)
	{
		List<String> result = new ArrayList<String>(5);
		for (IPlayerPermissions hook : getHooks(IPlayerPermissions.class))
		{
			List<String> groups = hook.getUserGroups(player);
			if (groups != null)
				result.addAll(groups);
		}
		if (result.isEmpty())
			result.add("unknown");
		return ImmutableList.copyOf(result);
	}

	@Override
	public boolean setGroup(RunsafePlayer player, String group)
	{
		for (IPlayerPermissions hook : getHooks(IPlayerPermissions.class))
			if (hook.setGroup(player, group))
				return true;
		return false;
	}

	@Override
	public boolean canBuildNow(RunsafePlayer player)
	{
		List<IPlayerBuildPermission> buildPermissionHooks = getHooks(IPlayerBuildPermission.class);
		if (buildPermissionHooks.isEmpty())
			return true;
		for (IPlayerBuildPermission check : buildPermissionHooks)
			if (check.blockPlayerBuilding(player, player.getLocation()))
				return false;
		return true;
	}

	@Override
	public boolean hasPermission(RunsafeFakePlayer player, ImmutableList<String> memberOf, String permission)
	{
		for (IPlayerPermissions hook : getHooks(IPlayerPermissions.class))
		{
			List<String> permissions = hook.getPlayerPermissions(player);
			if (permissions != null && permissions.contains(permission))
				return true;

			for (String group : memberOf)
			{
				if (group == null)
					continue;
				permissions = hook.getGroupPermissions(group);
				if (permissions != null && permissions.contains(permission))
					return true;
			}
		}
		return false;
	}

	@Override
	public List<String> getGroups()
	{
		List<IPlayerPermissions> hooks = getHooks(IPlayerPermissions.class);
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
	public List<String> find(String playerName)
	{
		if (playerName == null || playerName.isEmpty())
			return ImmutableList.of();

		List<String> hits = new ArrayList<String>(1);
		for (IPlayerLookupService lookup : getHooks(IPlayerLookupService.class))
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

	@Override
	@Nullable
	public UUID getUniqueId(String playerName)
	{
		if (playerName == null || playerName.isEmpty() || playerName.length() > 16)
			return null;

		for (IPlayerLookupService lookup : getHooks(IPlayerLookupService.class))
			return lookup.findPlayerUniqueId(playerName);

		return null;
	}

	@Override
	@Nullable
	public String getPlayerName(UUID playerId)
	{
		if (playerId == null)
			return null;

		for (IPlayerLookupService lookup : getHooks(IPlayerLookupService.class))
			return lookup.getLatestUsername(playerId);

		return null;
	}

	private static <T> List<T> getHooks(Class<T> type)
	{
		return HookEngine.getHooks(type);
	}

	@Override
	public void addPermission(IPlayer player, String permission, String world)
	{
		for (IPlayerPermissions hook : getHooks(IPlayerPermissions.class))
			hook.addPermission(player, permission, world);
	}

	@Override
	public void addPermission(IPlayer player, String permission)
	{
		for (IPlayerPermissions hook : getHooks(IPlayerPermissions.class))
			hook.addPermission(player, permission);
	}

	@Override
	public void removePermission(IPlayer player, String permission, String world)
	{
		for (IPlayerPermissions hook : getHooks(IPlayerPermissions.class))
			hook.removePermission(player, permission, world);
	}

	@Override
	public void removePermission(IPlayer player, String permission)
	{
		for (IPlayerPermissions hook : getHooks(IPlayerPermissions.class))
			hook.removePermission(player, permission);
	}
}
