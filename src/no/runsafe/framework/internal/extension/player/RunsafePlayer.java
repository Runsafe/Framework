package no.runsafe.framework.internal.extension.player;

import com.google.common.collect.ImmutableList;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IUniverse;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.chunk.IChunk;
import no.runsafe.framework.api.hook.IPlayerExtensions;
import no.runsafe.framework.api.networking.IPacket;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.wrapper.BukkitLocation;
import no.runsafe.framework.internal.wrapper.player.BukkitPlayer;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.event.player.RunsafeOperatorEvent;
import no.runsafe.framework.minecraft.inventory.RunsafePlayerInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.text.ChatColour;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.joda.time.DateTime;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("LocalVariableOfConcreteClass")
public class RunsafePlayer extends BukkitPlayer implements IPlayer
{
	public RunsafePlayer(OfflinePlayer toWrap)
	{
		super(toWrap);
	}

	@Override
	public String getPrettyName()
	{
		return InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).decorate(this);
	}

	@Override
	@Nullable
	public String getLastSeen(IPlayer checker)
	{
		return InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).seen(this, checker);
	}

	@Override
	public boolean isNew()
	{
		return InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).isNew(this);
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
	public void teleport(IWorld world, double x, double y, double z)
	{
		ILocation target = world.getLocation(x, y, z);
		IChunk chunk = target.getChunk();
		if (chunk.isUnloaded())
			chunk.load();
		teleport(target);
	}

	@Override
	public Map<String, String> getData()
	{
		return InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).data(this);
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
			Location location = player.getLocation();
			data.put("game.location", String.format("[%.2f,%.2f,%.2f@%s]", location.getX(), location.getY(), location.getZ(), location.getWorld().getName()));
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
		return InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).logout(this);
	}

	@Override
	@Nullable
	public String getBanReason()
	{
		return InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).banReason(this);
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

	@Override
	public boolean shouldNotSee(@Nonnull IPlayer target)
	{
		return InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).shouldNotSee(this, target);
	}

	@Override
	public boolean isVanished()
	{
		return InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).isVanished(this);
	}

	@Override
	public boolean isPvPFlagged()
	{
		return InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).isPvPFlagged(this);
	}

	@Override
	public ImmutableList<String> getGroups()
	{
		return InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).getGroups(this);
	}

	@Override
	public boolean setGroup(String group)
	{
		return InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).setGroup(this, group);
	}

	@Override
	public boolean canBuildNow()
	{
		return InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).canBuildNow(this);
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
	public boolean hasItem(Item itemType, int amount)
	{
		RunsafePlayerInventory inventory = getInventory();
		return inventory != null && inventory.contains(itemType, amount);
	}

	@Override
	public boolean hasItemStrict(Item itemType, int amount)
	{
		int found = 0;
		RunsafePlayerInventory inventory = getInventory();

		for (int slot = 0; slot < inventory.getSize(); slot++)
		{
			RunsafeMeta itemStack = inventory.getItemInSlot(slot);

			if (itemStack == null || itemStack.getItemId() == 0)
				continue;

			if (itemStack.getItemId() == itemType.getItemID() && itemStack.getData().getData() == itemType.getData())
				found += itemStack.getAmount();

			if (found >= amount)
				return true;
		}
		return false;
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
	public void removeExactItem(RunsafeMeta item, int amount)
	{
		RunsafePlayerInventory inventory = getInventory();
		if (inventory != null)
		{
			inventory.removeExact(item, amount);
			updateInventory();
		}
	}

	@Override
	public void removeExactItem(RunsafeMeta item)
	{
		removeExactItem(item, 1);
	}

	@Override
	@Nullable
	public IUniverse getUniverse()
	{
		IWorld world = getWorld();
		return world == null ? null : world.getUniverse();
	}

	@Override
	public boolean isInUniverse(String universeName)
	{
		IUniverse universe = getUniverse();
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
	public void sendColouredMessage(String format, Object... params)
	{
		if (format != null)
			sendMessage(ChatColour.ToMinecraft(String.format(format, params)));
	}

	@SuppressWarnings("CastToConcreteClass")
	@Override
	public void throwToPoint(ILocation location)
	{
		ILocation playerLocation = getLocation();

		if (playerLocation != null)
			setVelocity(((BukkitLocation) location).toVector().subtract(((BukkitLocation) playerLocation).toVector()));
	}

	@SuppressWarnings("CastToConcreteClass")
	@Override
	public void throwFromPoint(ILocation location)
	{
		ILocation playerLocation = getLocation();

		if (playerLocation != null)
			setVelocity(((BukkitLocation) playerLocation).toVector().subtract(((BukkitLocation) location).toVector()));
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
		IWorld world = getWorld();
		if (world != null)
			return world.getName();

		return "";
	}

	@Nullable
	@Override
	public String getIP()
	{
		if (player == null)
			return null;
		return player.getAddress().getAddress().getHostAddress();
	}

	@Override
	public int getOldLevel()
	{
		// ToDo: Fix this.
		return 0;
	}

	@Override
	public void sendPacket(IPacket packet)
	{
		packet.sendPacket(this);
	}

	@Override
	public void addPermission(String permission)
	{
		InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).addPermission(this, permission);
	}

	@Override
	public void addPermission(String permission, String world)
	{
		InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).addPermission(this, permission, world);
	}

	@Override
	public void removePermission(String permission)
	{
		InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).removePermission(this, permission);
	}

	@Override
	public void removePermission(String permission, String world)
	{
		InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).removePermission(this, permission, world);
	}
}
