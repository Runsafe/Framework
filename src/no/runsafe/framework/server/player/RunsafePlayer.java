package no.runsafe.framework.server.player;

import com.avaje.ebean.enhance.ant.OfflineFileTransform;
import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.RunsafeWorld;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.entity.Player;

public class RunsafePlayer
{
	public RunsafePlayer(String playerName)
	{
		Server server = RunsafePlugin.getPluginKernel().getComponent(Server.class);
		player = server.getPlayer(playerName);
		if(player == null)
			basePlayer = server.getOfflinePlayer(playerName);
	}

	public RunsafePlayer(Player toWrap)
	{
		player = toWrap;
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
		return player.getExp();
	}

	public void setXP(float points)
	{
		player.setExp(points);
	}

	public int getLevel()
	{
		return player.getLevel();
	}

	public void setLevel(int level)
	{
		player.setLevel(level);
	}

	public void sendBlockChange(RunsafeLocation location, int itemId, byte data)
	{
		player.sendBlockChange(location.getRaw(), itemId, data);
	}

	public void setFallDistance(float distance)
	{
		player.setFallDistance(distance);
	}

	public void teleport(RunsafeLocation location)
	{
		player.teleport(location.getRaw());
	}

	public void teleport(RunsafeWorld world, double x, double y, double z)
	{
		player.teleport(new Location(world.getRaw(), x, y, z));
	}

	public RunsafeItemStack getItemInHand()
	{
		return new RunsafeItemStack(player.getItemInHand());
	}

	public RunsafeLocation getLocation()
	{
		return new RunsafeLocation(player.getLocation());
	}

	public void sendMessage(String message)
	{
		player.sendMessage(message);
	}

	public RunsafeWorld getWorld()
	{
		return new RunsafeWorld(player.getWorld());
	}

	public OfflinePlayer getRaw()
	{
		return this.player;
	}

	public RunsafeInventory getInventory()
	{
		return new RunsafeInventory(player.getInventory());
	}

	@SuppressWarnings("deprecation")
	public void updateInventory()
	{
		player.updateInventory();
	}

	public boolean hasPermission(String permission)
	{
		return player.hasPermission(permission);
	}

	private Player player;
	private OfflinePlayer basePlayer;
}
