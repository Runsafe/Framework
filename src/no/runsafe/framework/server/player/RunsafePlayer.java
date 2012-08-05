package no.runsafe.framework.server.player;

import no.runsafe.framework.extensibility.ITeleport;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.RunsafeWorld;
import no.runsafe.framework.server.entity.RunsafeLivingEntity;
import no.runsafe.framework.server.inventory.IInventoryHolder;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class RunsafePlayer extends RunsafeLivingEntity implements IInventoryHolder
{
	public static void setTeleporter(ITeleport teleporter)
	{
		teleportHook = teleporter;
	}

	public RunsafePlayer(Player toWrap)
	{
		super(toWrap);
		player = toWrap;
		basePlayer = toWrap;
	}

	public RunsafePlayer(OfflinePlayer toWrap)
	{
		super((toWrap instanceof Player) ? (Player) toWrap : null);
		if(toWrap instanceof Player)
			player = (Player) toWrap;
		else
			player = null;
		basePlayer = toWrap;
	}

	public String getName()
	{
		return basePlayer.getName();
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

	public float getXP()
	{
		if(player == null)
			return 0;

		return player.getExp();
	}

	public void setXP(float points)
	{
		if(player != null)
			player.setExp(points);
	}

	public int getLevel()
	{
		if(player == null)
			return 0;

		return player.getLevel();
	}

	public void setLevel(int level)
	{
		if(player != null)
			player.setLevel(level);
	}

	public void sendBlockChange(RunsafeLocation location, int itemId, byte data)
	{
		if(player != null)
			player.sendBlockChange(location.getRaw(), itemId, data);
	}

	public void teleport(RunsafeWorld world, double x, double y, double z)
	{
		teleport(new RunsafeLocation(world, x, y, z));
	}

	public RunsafeItemStack getItemInHand()
	{
		if(player != null)
			return new RunsafeItemStack(player.getItemInHand());

		return null;
	}

	public void sendMessage(String message)
	{
		if(player != null)
			player.sendMessage(message);
	}

	public Player getRawPlayer()
	{
		return this.player;
	}

	public RunsafeInventory getInventory()
	{
		if(player != null)
			return new RunsafeInventory(player.getInventory());

		return null;
	}

	@SuppressWarnings("deprecation")
	public void updateInventory()
	{
		if(player != null)
			player.updateInventory();
	}

	public boolean hasPermission(String permission)
	{
		return player != null && player.hasPermission(permission);
	}

	private final Player player;
	private final OfflinePlayer basePlayer;
	private static ITeleport teleportHook;
}
