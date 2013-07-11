package no.runsafe.framework.internal.wrapper.player;

import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.block.RunsafeBlock;
import no.runsafe.framework.minecraft.entity.RunsafeLivingEntity;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.inventory.RunsafePlayerInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class BukkitPlayer extends RunsafeLivingEntity implements IInventoryHolder
{
	protected BukkitPlayer(OfflinePlayer toWrap)
	{
		super((toWrap instanceof Player) ? (Player) toWrap : null);
		player = toWrap instanceof Player ? (Player) toWrap : null;
		basePlayer = toWrap;
	}

	public String getName()
	{
		if (basePlayer == null)
			return null;
		return basePlayer.getName();
	}

	public void closeInventory()
	{
		this.player.closeInventory();
	}

	public boolean hasPlayedBefore()
	{
		return basePlayer.hasPlayedBefore();
	}

	public boolean isOnline()
	{
		return basePlayer.isOnline();
	}

	public void setPlayerListName(String playerName)
	{
		if (player == null)
			return;
		if (playerName.length() > 16)
			this.player.setPlayerListName(playerName.substring(0, 16));
		else
			this.player.setPlayerListName(playerName);
	}

	public boolean isOP()
	{
		return basePlayer.isOp();
	}


	public boolean isWhitelisted()
	{
		return basePlayer.isWhitelisted();
	}

	@Deprecated
	public boolean isBanned()
	{
		return !isNotBanned();
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
		if (player == null)
			return 0;

		return player.getExp();
	}

	public void setXP(float points)
	{
		if (player != null)
			player.setExp(points);
	}

	public int getLevel()
	{
		if (player == null)
			return 0;

		return player.getLevel();
	}

	public void setLevel(int level)
	{
		if (player != null)
			player.setLevel(level);
	}

	public void sendBlockChange(RunsafeBlock block, byte data)
	{
		sendBlockChange(block.getLocation(), block.getTypeId(), data);
	}

	public void sendBlockChange(RunsafeLocation location, int itemId, byte data)
	{
		if (player != null)
			player.sendBlockChange(location.getRaw(), itemId, data);
	}

	public RunsafeMeta getItemInHand()
	{
		if (player == null)
			return null;
		return ObjectWrapper.convert(player.getItemInHand());
	}

	public void sendMessage(String message)
	{
		if (player != null)
			player.sendMessage(message);
	}

	public Player getRawPlayer()
	{
		return this.player;
	}

	public RunsafePlayerInventory getInventory()
	{
		if (player == null)
			return null;

		return new RunsafePlayerInventory(player.getInventory());
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

	public GameMode getGameMode()
	{
		return this.player.getGameMode();
	}

	public void setGameMode(GameMode gameMode)
	{
		this.player.setGameMode(gameMode);
	}

	public void openInventory(RunsafeInventory inventory)
	{
		this.player.openInventory(inventory.getRaw());
	}

	public int getFoodLevel()
	{
		return player.getFoodLevel();
	}

	public void setFoodLevel(int level)
	{
		player.setFoodLevel(level);
	}

	public float getSaturation()
	{
		return player.getSaturation();
	}

	public void setSaturation(float saturation)
	{
		player.setSaturation(saturation);
	}

	protected final Player player;
	protected final OfflinePlayer basePlayer;
}
