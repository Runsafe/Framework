package no.runsafe.framework.internal.wrapper.player;

import net.minecraft.server.v1_12_R1.Entity;
import net.minecraft.server.v1_12_R1.EntityHuman;
import net.minecraft.server.v1_12_R1.EntityTypes;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.hook.IPlayerExtensions;
import no.runsafe.framework.api.minecraft.IAnimalTamer;
import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.LegacyMaterial;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.Sound;
import no.runsafe.framework.minecraft.entity.RunsafeLivingEntity;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.inventory.RunsafePlayerInventory;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.text.ChatColour;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;
import java.net.InetSocketAddress;
import java.util.UUID;

public class BukkitPlayer extends RunsafeLivingEntity implements IInventoryHolder, IAnimalTamer
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
		if (playerName != null)
			return playerName;

		if (nullName || basePlayer == null)
			return null;

		playerName = basePlayer.getName();
		if (playerName != null)
			return playerName;

		playerName = InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).getPlayerName(getUniqueId());
		if (playerName != null)
			return playerName;

		nullName = true;
		return null;
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
			player.sendBlockChange(ObjectUnwrapper.convert(location), itemId, data);
	}

	public void sendSignChange(ILocation location, String line1, String line2, String line3, String line4)
	{
		if (player != null)
			player.sendSignChange(ObjectUnwrapper.convert(location), new String[]{line1, line2, line3, line4});
	}

	public void setCompassTarget(ILocation location)
	{
		if (player != null)
			player.setCompassTarget(ObjectUnwrapper.convert(location));
	}

	public ILocation getCompassTarget()
	{
		return player == null ? null : ObjectWrapper.convert(player.getCompassTarget());
	}

	public void playSound(Sound sound)
	{
		playSound(sound, 5, 1);
	}

	public void playSound(Sound sound, float volume, float pitch)
	{
		if (player != null)
			player.playSound(player.getLocation(), sound.getSound(), volume, pitch);
	}

	@Nullable
	public RunsafeMeta getItemInMainHand()
	{
		return player == null ? null : ObjectWrapper.convert(player.getInventory().getItemInMainHand());
	}

	@Nullable
	public RunsafeMeta getItemInOffHand()
	{
		return player == null ? null : ObjectWrapper.convert(player.getInventory().getItemInOffHand());
	}

	public void setItemInMainHand(RunsafeMeta itemStack)
	{
		if (player != null)
			player.getInventory().setItemInMainHand(itemStack.getRaw());
	}

	public void setItemInOffHand(RunsafeMeta itemStack)
	{
		if (player != null)
			player.getInventory().setItemInOffHand(itemStack.getRaw());
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

	public void performCommand(String command)
	{
		if (player != null)
		{
			player.performCommand(command);
		}
	}

	@Nullable
	public String getPlayerListName()
	{
		if (player == null)
			return null;

		return player.getPlayerListName();
	}

	public void setPlayerListName(String name)
	{
		if (player != null)
			player.setPlayerListName(name);
	}

	@Override
	public UUID getUniqueId()
	{
		if (basePlayer == null)
			return null;

		return basePlayer.getUniqueId();
	}

	public IEntity getLeftShoulderEntity()
	{
		if (player == null || !(player instanceof EntityHuman))
			return null;

		EntityHuman human = (EntityHuman)player;
		Entity entity = EntityTypes.a(human.getShoulderEntityLeft(), human.world);
		return entity == null ? null : ObjectWrapper.convert(entity.getBukkitEntity());
	}

	public IEntity getRightShoulderEntity()
	{
		if (player == null || !(player instanceof EntityHuman))
			return null;

		EntityHuman human = (EntityHuman)player;
		Entity entity = EntityTypes.a(human.getShoulderEntityRight(), human.world);
		return entity == null ? null : ObjectWrapper.convert(entity.getBukkitEntity());
	}

	public void setLeftShoulderEntity(IEntity entity)
	{
		if (player == null || !(player instanceof EntityHuman))
			return;
		if (entity == null)
		{
			((EntityHuman)player).setShoulderEntityLeft(null);
			return;
		}
		((EntityHuman)player).setShoulderEntityLeft(ObjectUnwrapper.convert(entity));
	}

	public void setRightShoulderEntity(IEntity entity)
	{
		if (player == null || !(player instanceof EntityHuman))
			return;
		if (entity == null)
		{
			((EntityHuman)player).setShoulderEntityRight(null);
			return;
		}
		((EntityHuman)player).setShoulderEntityRight(ObjectUnwrapper.convert(entity));
	}

	/**
	 * Sends a title to the player.
	 * If either value is null, it will be treated as blank.
	 * @param title Main title message.
	 * @param subtitle Subtitle message.
	 */
	@Deprecated
	public void sendTitle(String title, String subtitle)
	{
		sendtitle(title, subtitle, 10, 70, 20);
	}

	public void sendtitle(String title, String subtitle, int fadeIn, int stay, int fadeOut)
	{
		if (player == null)
			return;

		if (title == null)
			title = "";

		if (subtitle == null)
			subtitle = "";

		player.sendTitle(ChatColour.ToMinecraft(title), ChatColour.ToMinecraft(subtitle), fadeIn, stay, fadeOut);
	}

	/**
	 * Resets title sent to player.
	 * Makes title disappear from player's view if it hasn't already
	 */
	public void resetTitle()
	{
		if (player != null)
			player.resetTitle();
	}

	public void setFacing(ILocation targetLocation)
	{
		if (player == null)
			return;

		Location target = ObjectUnwrapper.convert(targetLocation);
		if (target == null)
			return;

		Vector dir = target.clone().subtract(player.getEyeLocation()).toVector();
		Location loc = player.getLocation().setDirection(dir);
		player.teleport(loc);
	}

	public ILocation getLocationBehindPlayer(double distance, boolean getHighestBlock)
	{
		if (player == null)
			return null;

		Location playerLocation = player.getLocation();
		Location location = playerLocation.clone();

		// Convert playerYaw from degrees to radians
		double yawRadians = Math.toRadians(playerLocation.getYaw());

		// Calculate the change in X and Z coordinates
		int deltaX = (int) Math.floor(-distance * Math.sin(yawRadians));
		int deltaZ = (int) Math.floor(-distance * Math.cos(yawRadians));

		// Update the player's new coordinates
		location.add(deltaX, 0, deltaZ);

		// Find to topmost block if requested
		if (getHighestBlock)
		{
			// If a massive difference, ignore
			Location top = location.getWorld().getHighestBlockAt(location.getBlockX(), location.getBlockZ()).getLocation();
			if (Math.abs(top.getBlockY() - playerLocation.getBlockY()) > 5)
			{
				top.setY(playerLocation.getY());
			}
		}

		// Face the player
		Vector dir = playerLocation.clone().subtract(location).toVector();
		location.setDirection(dir);

		return ObjectWrapper.convert(location);
	}

	protected String playerName = null;
	private boolean nullName = false;
	@Nullable
	protected final Player player;
	protected final OfflinePlayer basePlayer;
}
