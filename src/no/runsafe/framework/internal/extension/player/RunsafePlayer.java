package no.runsafe.framework.internal.extension.player;

import com.google.common.collect.ImmutableList;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IUniverse;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.hooks.PlayerExtensions;
import no.runsafe.framework.internal.wrapper.BukkitLocation;
import no.runsafe.framework.internal.wrapper.player.BukkitPlayer;
import no.runsafe.framework.minecraft.Item;
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
		return PlayerExtensions.decorate(this);
	}

	@Override
	@Nullable
	public String getLastSeen(IPlayer checker)
	{
		return PlayerExtensions.seen(this, checker);
	}

	@Override
	public boolean isNew()
	{
		return PlayerExtensions.isNew(this);
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
		RunsafeChunk chunk = target.getChunk();
		if (chunk.isUnloaded())
			chunk.load();
		teleport(target);
	}

	@Override
	public Map<String, String> getData()
	{
		return PlayerExtensions.data(this);
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
		return PlayerExtensions.logout(this);
	}

	@Override
	@Nullable
	public String getBanReason()
	{
		return PlayerExtensions.banReason(this);
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
		return PlayerExtensions.shouldNotSee(this, target);
	}

	@Override
	public boolean isVanished()
	{
		return PlayerExtensions.isVanished(this);
	}

	@Override
	public boolean isPvPFlagged()
	{
		return PlayerExtensions.isPvPFlagged(this);
	}

	@Override
	public ImmutableList<String> getGroups()
	{
		return PlayerExtensions.getGroups(this);
	}

	@Override
	public boolean setGroup(String group)
	{
		return PlayerExtensions.setGroup(this, group);
	}

	@Override
	public boolean canBuildNow()
	{
		return PlayerExtensions.canBuildNow(this);
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
}
