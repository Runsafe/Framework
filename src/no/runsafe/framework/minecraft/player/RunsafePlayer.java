package no.runsafe.framework.minecraft.player;

import com.google.common.collect.ImmutableList;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.api.hook.*;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.HookEngine;
import no.runsafe.framework.internal.wrapper.player.BukkitPlayer;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.Universe;
import no.runsafe.framework.minecraft.chunk.RunsafeChunk;
import no.runsafe.framework.minecraft.event.player.RunsafeOperatorEvent;
import no.runsafe.framework.minecraft.inventory.RunsafePlayerInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.text.ChatColour;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.joda.time.DateTime;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"OverlyCoupledClass", "LocalVariableOfConcreteClass"})
public class RunsafePlayer extends BukkitPlayer implements ICommandExecutor, IPlayer
{
	public RunsafePlayer(OfflinePlayer toWrap)
	{
		super(toWrap);
	}

	@Override
	public String getPrettyName()
	{
		List<IPlayerNameDecorator> decoratorHooks = HookEngine.hookContainer.getComponents(IPlayerNameDecorator.class);
		String name = getName();
		if (!decoratorHooks.isEmpty())
			for (IPlayerNameDecorator decorator : decoratorHooks)
				name = decorator.DecorateName(this, name);
		return name;
	}

	@Override
	@Nullable
	public String getLastSeen(IPlayer checker)
	{
		List<IPlayerSeen> seenHooks = HookEngine.hookContainer.getComponents(IPlayerSeen.class);
		if (!seenHooks.isEmpty())
			return seenHooks.get(0).GetLastSeen(this, checker);

		return null;
	}

	@Override
	public boolean isNew()
	{
		List<IPlayerSessionDataProvider> dataHooks = HookEngine.hookContainer.getComponents(IPlayerSessionDataProvider.class);
		if (isOnline() || dataHooks.isEmpty())
			return false;

		for (IPlayerSessionDataProvider provider : dataHooks)
			if (provider.IsFirstSession(this))
				return true;

		return false;
	}

	@Override
	public void OP()
	{
		basePlayer.setOp(true);
		new RunsafeOperatorEvent(this, true).Fire();
	}

	@Override
	public void deOP()
	{
		basePlayer.setOp(false);
		new RunsafeOperatorEvent(this, false).Fire();
	}

	@Override
	public boolean isSurvivalist()
	{
		return player != null && player.getGameMode() == GameMode.SURVIVAL;
	}

	@Override
	public boolean isCreative()
	{
		return player != null && player.getGameMode() == GameMode.CREATIVE;
	}

	@Override
	public boolean isAdventurer()
	{
		return player != null && player.getGameMode() == GameMode.ADVENTURE;
	}

	@Override
	public void teleport(RunsafeWorld world, double x, double y, double z)
	{
		RunsafeLocation target = new RunsafeLocation(world, x, y, z);
		RunsafeChunk chunk = target.getChunk();
		if (chunk.isUnloaded())
			chunk.load();
		teleport(target);
	}

	@Override
	public Map<String, String> getData()
	{
		List<IPlayerDataProvider> dataHooks = HookEngine.hookContainer.getComponents(IPlayerDataProvider.class);
		Map<String, String> results = getBasicData();
		for (IPlayerDataProvider provider : dataHooks)
		{
			Map<String, String> data = provider.GetPlayerData(this);
			if (data != null)
				results.putAll(data);
		}
		return results;
	}

	@Override
	@SuppressWarnings("HardcodedFileSeparator")
	public Map<String, String> getBasicData()
	{
		Map<String, String> data = new LinkedHashMap<String, String>(7);
		if (player != null && isOnline())
		{
			data.put("game.ip",
				String.format("%s [%s]",
					player.getAddress().getAddress().getHostAddress(),
					player.getAddress().getHostName()
				)
			);
			data.put("game.mode", player.getGameMode().name());
			data.put("game.flying", player.isFlying() ? "true" : "false");
			data.put("game.health", String.format("%.1f/%.1f", getHealth(), getMaxHealth()));
		}
		data.put("game.experience", String.format("%.1f", getXP()));
		data.put("game.level", String.format("%d", getLevel()));
		data.put("game.op", isOP() ? "true" : "false");
		return data;
	}

	@Override
	@Nullable
	public DateTime lastLogout()
	{
		List<IPlayerSessionDataProvider> dataHooks = HookEngine.hookContainer.getComponents(IPlayerSessionDataProvider.class);
		if (isOnline() || dataHooks.isEmpty())
			return null;
		DateTime logout = null;
		for (IPlayerSessionDataProvider provider : dataHooks)
		{
			DateTime value = provider.GetPlayerLogout(this);
			if (value != null && (logout == null || value.isAfter(logout)))
				logout = value;
		}
		return logout;
	}

	@Override
	@Nullable
	public String getBanReason()
	{
		List<IPlayerSessionDataProvider> dataHooks = HookEngine.hookContainer.getComponents(IPlayerSessionDataProvider.class);
		if (isNotBanned() || dataHooks.isEmpty())
			return null;
		for (IPlayerSessionDataProvider provider : dataHooks)
		{
			String reason = provider.GetPlayerBanReason(this);
			if (reason != null)
				return reason;
		}
		return null;
	}

	@Override
	@Nullable
	public String getDataValue(String key)
	{
		Map<String, String> data = getData();
		if (data.containsKey(key))
			return data.get(key);
		return null;
	}

	@Deprecated
	public boolean canSee(IPlayer target)
	{
		return !shouldNotSee(target);
	}

	@Override
	public boolean shouldNotSee(@Nonnull IPlayer target)
	{
		//noinspection ConstantConditions
		if (getName().equals(target.getName()))
			return false;

		List<IPlayerVisibility> visibilityHooks = HookEngine.hookContainer.getComponents(IPlayerVisibility.class);
		if (visibilityHooks.isEmpty())
			return false;

		for (IPlayerVisibility check : visibilityHooks)
			if (check.isPlayerHidden(this, target))
				return true;
		return false;
	}

	@Override
	public boolean isVanished()
	{
		List<IPlayerVisibility> visibilityHooks = HookEngine.hookContainer.getComponents(IPlayerVisibility.class);
		if (visibilityHooks.isEmpty())
			return false;
		for (IPlayerVisibility check : visibilityHooks)
			if (check.isPlayerVanished(this))
				return true;
		return false;
	}

	@Override
	public boolean isPvPFlagged()
	{
		List<IPlayerPvPFlag> pvpFlagHooks = HookEngine.hookContainer.getComponents(IPlayerPvPFlag.class);
		if (pvpFlagHooks.isEmpty())
			return true;
		for (IPlayerPvPFlag hook : pvpFlagHooks)
			if (hook.isPvPDisabled(this))
				return false;
		return true;
	}

	@Override
	public ImmutableList<String> getGroups()
	{
		List<String> result = new ArrayList<String>(5);
		for (IPlayerPermissions hook : HookEngine.hookContainer.getComponents(IPlayerPermissions.class))
		{
			List<String> groups = hook.getUserGroups(this);
			if (groups != null)
				result.addAll(groups);
		}
		if (result.isEmpty())
			result.add("unknown");
		return ImmutableList.copyOf(result);
	}

	@Override
	public boolean setGroup(String group)
	{
		for (IPlayerPermissions hook : HookEngine.hookContainer.getComponents(IPlayerPermissions.class))
			if (hook.setGroup(this, group))
				return true;
		return false;
	}

	@Override
	public boolean canBuildNow()
	{
		List<IPlayerBuildPermission> buildPermissionHooks =
			HookEngine.hookContainer.getComponents(IPlayerBuildPermission.class);
		if (buildPermissionHooks.isEmpty())
			return true;
		for (IPlayerBuildPermission check : buildPermissionHooks)
			if (check.blockPlayerBuilding(this, getLocation()))
				return false;
		return true;
	}

	@Override
	public void give(RunsafeMeta... items)
	{
		if (player == null || items == null || items.length < 1)
			return;
		RunsafePlayerInventory inventory = getInventory();
		if (inventory != null)
		{
			inventory.addItems(items);
			updateInventory();
		}
	}

	@Override
	public void removeItem(Item itemType, int amount)
	{
		RunsafePlayerInventory inventory = getInventory();
		if (inventory != null)
		{
			inventory.remove(itemType, amount);
			updateInventory();
		}
	}

	@Override
	public void removeItem(Item itemType)
	{
		removeItem(itemType, itemType.getStackSize());
	}

	@Override
	@Nullable
	public Universe getUniverse()
	{
		RunsafeWorld world = getWorld();
		return world == null ? null : world.getUniverse();
	}

	@Override
	public boolean isInUniverse(String universeName)
	{
		Universe universe = getUniverse();
		return universe != null && universe.getName().equals(universeName);
	}

	@Override
	public void clearInventory()
	{
		if (player == null)
			return;

		player.getInventory().clear();
		updateInventory();
	}

	@Override
	@Deprecated
	public void sendColouredMessage(String message)
	{
		if (message != null)
			sendMessage(ChatColour.ToMinecraft(message));
	}

	@Override
	public void sendColouredMessage(String format, Object... params)
	{
		if (format != null)
			sendMessage(ChatColour.ToMinecraft(String.format(format, params)));
	}

	@Override
	public void throwToPoint(RunsafeLocation location)
	{
		RunsafeLocation playerLocation = getLocation();

		if (playerLocation != null)
			setVelocity(location.toVector().subtract(playerLocation.toVector()));
	}

	@Override
	public void throwFromPoint(RunsafeLocation location)
	{
		RunsafeLocation playerLocation = getLocation();

		if (playerLocation != null)
			setVelocity(playerLocation.toVector().subtract(location.toVector()));
	}

	@Override
	public void heal(double amount)
	{
		double heal = getHealth() + amount;
		setHealth(heal);
	}

	@Override
	public String getWorldName()
	{
		RunsafeWorld world = getWorld();
		if (world != null)
			return world.getName();

		return "";
	}
}
