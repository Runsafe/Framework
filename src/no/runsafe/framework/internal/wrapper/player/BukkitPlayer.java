package no.runsafe.framework.internal.wrapper.player;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.minecraft.IAnimalTamer;
import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.internal.LegacyMaterial;
import no.runsafe.framework.internal.wrapper.IWrapper;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeLivingEntity;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.inventory.RunsafePlayerInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.net.InetSocketAddress;

public class BukkitPlayer extends RunsafeLivingEntity implements IInventoryHolder, IAnimalTamer, IWrapper<OfflinePlayer>
{
	protected BukkitPlayer(OfflinePlayer toWrap)
	{
		super(toWrap instanceof Player ? (Player) toWrap : null);
		player = toWrap instanceof Player ? (Player) toWrap : null;
		basePlayer = toWrap;
	}

	@Override
	@Nullable
	public String getName()
	{
		return basePlayer == null ? null : basePlayer.getName();
	}

	public void closeInventory()
	{
		if (player != null)
			player.closeInventory();
	}

	public boolean hasPlayedBefore()
	{
		return basePlayer.hasPlayedBefore();
	}

	public boolean isOnline()
	{
		return basePlayer.isOnline();
	}

	public boolean isOP()
	{
		return basePlayer.isOp();
	}

	public boolean isWhitelisted()
	{
		return basePlayer.isWhitelisted();
	}

	public boolean isNotBanned()
	{
		return !basePlayer.isBanned();
	}

	public void setBanned(boolean banned)
	{
		basePlayer.setBanned(banned);
	}

	public void kick(String reason)
	{
		if (player != null)
			player.kickPlayer(reason);
	}

	public float getXP()
	{
		return player == null ? 0.0f : player.getExp();
	}

	public void setXP(float points)
	{
		if (player != null)
			player.setExp(points);
	}

	public int getLevel()
	{
		return player == null ? 0 : player.getLevel();
	}

	public void setLevel(int level)
	{
		if (player != null)
			player.setLevel(level);
	}

	public void sendBlockChange(IBlock block, byte data)
	{
		sendBlockChange(block.getLocation(), LegacyMaterial.getIdOf(block.getMaterial().getType()), data);
	}

	public void sendBlockChange(ILocation location, int itemId, byte data)
	{
		if (player != null)
			player.sendBlockChange((Location) ObjectUnwrapper.convert(location), itemId, data);
	}

	@Nullable
	public RunsafeMeta getItemInHand()
	{
		return player == null ? null : ObjectWrapper.convert(player.getItemInHand());
	}

	public void sendMessage(String message)
	{
		if (player != null)
			player.sendMessage(message);
	}

	@Override
	public Player getRaw()
	{
		return player;
	}

	public OfflinePlayer getBasePlayer()
	{
		return basePlayer;
	}

	@Override
	@Nullable
	public RunsafePlayerInventory getInventory()
	{
		return player == null ? null : new RunsafePlayerInventory(player.getInventory());
	}

	@SuppressWarnings("deprecation")
	public void updateInventory()
	{
		if (player != null)
			player.updateInventory();
	}

	public boolean hasPermission(String permission)
	{
		return player != null && player.hasPermission(permission);
	}

	@Nullable
	public GameMode getGameMode()
	{
		return player == null ? null : player.getGameMode();
	}

	public void setGameMode(GameMode gameMode)
	{
		if (player != null)
			player.setGameMode(gameMode);
	}

	public void openInventory(RunsafeInventory inventory)
	{
		if (player != null)
			player.openInventory(inventory.getRaw());
	}

	public int getFoodLevel()
	{
		return player == null ? 0 : player.getFoodLevel();
	}

	public void setFoodLevel(int level)
	{
		if (player != null)
			player.setFoodLevel(level);
	}

	public float getSaturation()
	{
		return player == null ? 0.0f : player.getSaturation();
	}

	public void setSaturation(float saturation)
	{
		if (player != null)
			player.setSaturation(saturation);
	}

	@Nullable
	public RunsafeMeta getHelmet()
	{
		if (player == null)
			return null;
		return ObjectWrapper.convert(player.getInventory().getHelmet());
	}

	@Nullable
	public RunsafeMeta getChestplate()
	{
		if (player == null)
			return null;
		return ObjectWrapper.convert(player.getInventory().getChestplate());
	}

	@Nullable
	public RunsafeMeta getLeggings()
	{
		if (player == null)
			return null;
		return ObjectWrapper.convert(player.getInventory().getLeggings());
	}

	@Nullable
	public RunsafeMeta getBoots()
	{
		if (player == null)
			return null;
		return ObjectWrapper.convert(player.getInventory().getBoots());
	}

	public void setHelmet(RunsafeMeta itemStack)
	{
		if (player != null)
			player.getInventory().setHelmet(itemStack.getRaw());
	}

	public void setChestplate(RunsafeMeta itemStack)
	{
		if (player != null)
			player.getInventory().setChestplate(itemStack.getRaw());
	}

	public void setLeggings(RunsafeMeta itemStack)
	{
		if (player != null)
			player.getInventory().setLeggings(itemStack.getRaw());
	}

	public void setBoots(RunsafeMeta itemStack)
	{
		if (player != null)
			player.getInventory().setBoots(itemStack.getRaw());
	}

	@Nullable
	public InetSocketAddress getAddress()
	{
		if (player == null)
			return null;
		return player.getAddress();
	}

	public boolean performCommand(String command)
	{
		return player != null && player.performCommand(command);
	}

	@Nullable
	protected final Player player;
	protected final OfflinePlayer basePlayer;
}
