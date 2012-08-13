package no.runsafe.framework.server;

import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.*;
import java.util.logging.Logger;

public class RunsafeServer
{
	public static RunsafeServer Instance = null;

	public RunsafeServer(Server toWrap)
	{
		this.server = toWrap;
	}

	public void banIP(String address)
	{
		this.server.banIP(address);
	}

	public int broadcastMessage(String message, String permission)
	{
		return this.server.broadcast(message, permission);
	}

	public int broadcastMessage(String message)
	{
		return this.server.broadcastMessage(message);
	}

	public void clearRecipes()
	{
		this.server.clearRecipes();
	}

	public boolean getAllowEnd()
	{
		return this.server.getAllowEnd();
	}

	public boolean getAllowFlight()
	{
		return this.server.getAllowFlight();
	}

	public boolean getAllowNether()
	{
		return this.server.getAllowNether();
	}

	public List<RunsafePlayer> getBannedPlayers()
	{
		ArrayList<RunsafePlayer> result = new ArrayList<RunsafePlayer>();
		for (OfflinePlayer banned : this.server.getBannedPlayers())
			result.add(new RunsafePlayer(banned));
		return result;
	}

	public String getBukkitVersion()
	{
		return this.server.getBukkitVersion();
	}

	public Map<String, String[]> getCommandAliases()
	{
		return this.server.getCommandAliases();
	}

	public long getConnectionThrottle()
	{
		return this.server.getConnectionThrottle();
	}

	public boolean getGenerateStructures()
	{
		return this.server.getGenerateStructures();
	}

	public String getIp()
	{
		return this.server.getIp();
	}

	public Set<String> getIpBans()
	{
		return this.server.getIPBans();
	}

	public Logger getLogger()
	{
		return this.server.getLogger();
	}

	public int getMaxPlayers()
	{
		return this.server.getMaxPlayers();
	}

	public String getName()
	{
		return this.server.getName();
	}

	public RunsafePlayer getPlayer(String playerName)
	{
		return new RunsafePlayer(this.server.getOfflinePlayer(playerName));
	}

	public List<RunsafePlayer> getOfflinePlayers()
	{
		return ObjectWrapper.convert(server.getOfflinePlayers()); // RunsafePlayer.convert(server.getOfflinePlayers());
	}

	public boolean getOnlineMode()
	{
		return this.server.getOnlineMode();
	}

	public List<RunsafePlayer> getOnlinePlayers()
	{
		return ObjectWrapper.convert((OfflinePlayer[]) server.getOnlinePlayers());
		//return RunsafePlayer.convert((OfflinePlayer[]) server.getOnlinePlayers());
	}

	public List<RunsafePlayer> getOperators()
	{
		return ObjectWrapper.convert(server.getOperators()); // RunsafePlayer.convert(server.getOperators());
	}

	public RunsafePlayer getPlayerExact(String playerName)
	{
		return new RunsafePlayer(this.server.getPlayerExact(playerName));
	}

	public int getPort()
	{
		return this.server.getPort();
	}

	public String getServerId()
	{
		return this.server.getServerId();
	}

	public String getServerName()
	{
		return this.server.getServerName();
	}

	public int getSpawnRadius()
	{
		return this.server.getSpawnRadius();
	}

	public int getTicksPerAnimalSpawns()
	{
		return this.server.getTicksPerAnimalSpawns();
	}

	public int getTicksPerMonsterSpawns()
	{
		return this.server.getTicksPerMonsterSpawns();
	}

	public String getUpdateFolder()
	{
		return this.server.getUpdateFolder();
	}

	public int getViewDistance()
	{
		return this.server.getViewDistance();
	}

	public List<RunsafePlayer> getWhitelistedPlayers()
	{
		return ObjectWrapper.convert(server.getWhitelistedPlayers()); // RunsafePlayer.convert(this.server.getWhitelistedPlayers());
	}

	public RunsafeWorld getWorld(String worldName)
	{
		return ObjectWrapper.convert(this.server.getWorld(worldName));
	}

	public RunsafeWorld getWorld(UUID uid)
	{
		return ObjectWrapper.convert(this.server.getWorld(uid));
	}

	public File getWorldContainer()
	{
		return this.server.getWorldContainer();
	}

	public List<RunsafeWorld> getWorlds()
	{
		List<RunsafeWorld> returnList = new ArrayList<RunsafeWorld>();

		for (World world : this.server.getWorlds())
		{
			returnList.add(new RunsafeWorld(world));
		}

		return returnList;
	}

	public String getWorldType()
	{
		return this.server.getWorldType();
	}

	public boolean hasWhitelist()
	{
		return this.server.hasWhitelist();
	}

	public List<RunsafePlayer> matchPlayer(String playerName)
	{
		List<RunsafePlayer> returnList = new ArrayList<RunsafePlayer>();

		for (Player player : this.server.matchPlayer(playerName))
		{
			returnList.add(new RunsafePlayer(player));
		}

		return returnList;
	}

	public void reload()
	{
		this.server.reload();
	}

	public void reloadWhitelist()
	{
		this.server.reloadWhitelist();
	}

	public void resetRecipes()
	{
		this.server.resetRecipes();
	}

	public void savePlayers()
	{
		this.server.savePlayers();
	}

	public void setSpawnRadius(int radius)
	{
		this.server.setSpawnRadius(radius);
	}

	public void setWhitelist(boolean value)
	{
		this.server.setWhitelist(value);
	}

	public void shutdown()
	{
		this.server.shutdown();
	}

	public void unbanIp(String address)
	{
		this.server.unbanIP(address);
	}

	public boolean unloadWorld(String worldName, boolean save)
	{
		return this.server.unloadWorld(worldName, save);
	}

	public boolean unloadWorld(RunsafeWorld world, boolean save)
	{
		return this.unloadWorld(world.getName(), save);
	}

	public boolean useExactLoginLocation()
	{
		return this.server.useExactLoginLocation();
	}

	private final Server server;
}
