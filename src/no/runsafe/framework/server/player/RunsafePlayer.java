package no.runsafe.framework.server.player;

import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.RunsafeWorld;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RunsafePlayer {
	//	public RunsafePlayer(String playerName)
	//	{
	//		Server server = RunsafePlugin.getPluginKernel().getComponent(Server.class);
	//		player = server.getPlayer(playerName);
	//		if (player == null)
	//			basePlayer = server.getOfflinePlayer(playerName);
	//		else
	//			basePlayer = player;
	//	}

	public static List<RunsafePlayer> convert(OfflinePlayer[] players) {
		ArrayList<RunsafePlayer> result = new ArrayList<RunsafePlayer>();
		for(OfflinePlayer player : players)
			result.add(new RunsafePlayer(player));
		return result;
	}


	public static List<RunsafePlayer> convert(Set<OfflinePlayer> players) {
		ArrayList<RunsafePlayer> result = new ArrayList<RunsafePlayer>();
		for(OfflinePlayer player : players)
			result.add(new RunsafePlayer(player));
		return result;
	}

	public RunsafePlayer(Player toWrap) {
		player = toWrap;
		basePlayer = toWrap;
	}

	public RunsafePlayer(OfflinePlayer toWrap) {
		if(toWrap instanceof Player)
			player = (Player) toWrap;
		basePlayer = toWrap;
	}

	public String getName() {
		return basePlayer.getName();
	}

	public boolean hasPlayedBefore() {
		return basePlayer.hasPlayedBefore();
	}

	public boolean isOnline() {
		return basePlayer.isOnline();
	}

	public boolean isOP() {
		return basePlayer.isOp();
	}

	public boolean isWhitelisted() {
		return basePlayer.isWhitelisted();
	}

	public float getXP() {
		if(player == null)
			return 0;

		return player.getExp();
	}

	public void setXP(float points) {
		if(player != null)
			player.setExp(points);
	}

	public int getLevel() {
		if(player == null)
			return 0;

		return player.getLevel();
	}

	public void setLevel(int level) {
		if(player != null)
			player.setLevel(level);
	}

	public void sendBlockChange(RunsafeLocation location, int itemId, byte data) {
		if(player != null)
			player.sendBlockChange(location.getRaw(), itemId, data);
	}

	public void setFallDistance(float distance) {
		if(player != null)
			player.setFallDistance(distance);
	}

	public void teleport(RunsafeLocation location) {
		if(player != null)
			player.teleport(location.getRaw());
	}

	public void teleport(RunsafeWorld world, double x, double y, double z) {
		if(player != null)
			player.teleport(new Location(world.getRaw(), x, y, z));
	}

	public RunsafeItemStack getItemInHand() {
		if(player != null)
			return new RunsafeItemStack(player.getItemInHand());

		return null;
	}

	public RunsafeLocation getLocation() {
		if(player != null)
			return new RunsafeLocation(player.getLocation());

		return null;
	}

	public void sendMessage(String message) {
		if(player != null)
			player.sendMessage(message);
	}

	public RunsafeWorld getWorld() {
		if(player != null)
			return new RunsafeWorld(player.getWorld());

		return null;
	}

	public Player getRawPlayer() {
		return this.player;
	}

	public OfflinePlayer getRaw() {
		return this.basePlayer;
	}

	public RunsafeInventory getInventory() {
		if(player != null)
			return new RunsafeInventory(player.getInventory());

		return null;
	}

	@SuppressWarnings("deprecation")
	public void updateInventory() {
		if(player != null)
			player.updateInventory();
	}

	public boolean hasPermission(String permission) {
		return player != null && player.hasPermission(permission);
	}

	private Player player;
	private final OfflinePlayer basePlayer;

}
