package no.runsafe.framework.internal.wrapper;

import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.inventory.RunsafeInventoryHolder;
import no.runsafe.framework.minecraft.inventory.RunsafeInventoryType;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.framework.text.ChatColour;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

public abstract class BukkitServer
{
	protected BukkitServer(Server toWrap)
	{
		server = toWrap;
	}

	public void banIP(String address)
	{
		this.server.banIP(address);
	}

	public int broadcastMessage(String message, String permission)
	{
		if (message == null)
			return 0;
		return this.server.broadcast(ChatColour.ToMinecraft(message), permission);
	}

	public int broadcastMessage(String message)
	{
		if (message == null)
			return 0;
		return this.server.broadcastMessage(ChatColour.ToMinecraft(message));
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
		return ObjectWrapper.convert(server.getBannedPlayers());
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

	public RunsafePlayer getOfflinePlayerExact(String playerName)
	{
		if (playerName == null || playerName.isEmpty())
			return null;
		return new RunsafePlayer(server.getOfflinePlayer(playerName));
	}

	public List<RunsafePlayer> getOfflinePlayers()
	{
		return ObjectWrapper.convert(server.getOfflinePlayers());
	}

	public boolean getOnlineMode()
	{
		return this.server.getOnlineMode();
	}

	public List<RunsafePlayer> getOnlinePlayers()
	{
		return ObjectWrapper.convert((OfflinePlayer[]) server.getOnlinePlayers());
	}

	public List<RunsafePlayer> getOperators()
	{
		return ObjectWrapper.convert(server.getOperators());
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
		return ObjectWrapper.convert(server.getWhitelistedPlayers());
	}

	public List<RunsafePlayer> matchPlayer(String playerName)
	{
		if (playerName == null || playerName.isEmpty())
			return null;

		return ObjectWrapper.convert(server.matchPlayer(playerName));
	}

	public RunsafeWorld getWorld(String worldName)
	{
		if (worldName == null || worldName.isEmpty())
			return null;

		return ObjectWrapper.convert(this.server.getWorld(worldName));
	}

	public RunsafeWorld getWorld(UUID uid)
	{
		if (uid == null)
			return null;

		return ObjectWrapper.convert(this.server.getWorld(uid));
	}

	public List<RunsafeWorld> getWorlds()
	{
		return ObjectWrapper.convert(server.getWorlds());
	}

	public File getWorldContainer()
	{
		return this.server.getWorldContainer();
	}

	public String getWorldType()
	{
		return this.server.getWorldType();
	}

	public boolean hasWhitelist()
	{
		return this.server.hasWhitelist();
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
		if (address == null || address.isEmpty())
			return;

		this.server.unbanIP(address);
	}

	public boolean unloadWorld(String worldName, boolean save)
	{
		if (worldName == null || worldName.isEmpty())
			return false;

		return this.server.unloadWorld(worldName, save);
	}

	public boolean unloadWorld(RunsafeWorld world, boolean save)
	{
		if (world == null)
			return false;

		return this.unloadWorld(world.getName(), save);
	}

	public boolean useExactLoginLocation()
	{
		return this.server.useExactLoginLocation();
	}

	public RunsafeInventory createInventory(RunsafeInventoryHolder holder, int size, String name)
	{
		if (name == null)
			return createInventory(holder, size);

		if (holder == null)
			return ObjectWrapper.convert(this.server.createInventory(null, size, name));

		return ObjectWrapper.convert(this.server.createInventory(holder.getRaw(), size, name));
	}

	public RunsafeInventory createInventory(RunsafeInventoryHolder holder, int size)
	{
		if (holder == null)
			return ObjectWrapper.convert(this.server.createInventory(null, size));

		return ObjectWrapper.convert(this.server.createInventory(holder.getRaw(), size));
	}

	public RunsafeInventory createInventory(RunsafeInventoryHolder holder, RunsafeInventoryType type)
	{
		if (type == null)
			return null;

		if (holder == null)
			return ObjectWrapper.convert(this.server.createInventory(null, type.getRaw()));

		return ObjectWrapper.convert(this.server.createInventory(holder.getRaw(), type.getRaw()));
	}

	public void stop()
	{
		server.shutdown();
	}

	public void unbanIP(String ip)
	{
		if (ip == null || ip.isEmpty())
			return;

		server.unbanIP(ip);
	}

	public boolean isHardcore()
	{
		return server.isHardcore();
	}

	public int getWaterAnimalSpawnLimit()
	{
		return server.getWaterAnimalSpawnLimit();
	}

	public int getAmbientSpawnLimit()
	{
		return server.getAmbientSpawnLimit();
	}

	public int getMonsterSpawnLimit()
	{
		return server.getMonsterSpawnLimit();
	}

	public int getAnimalSpawnLimit()
	{
		return server.getAnimalSpawnLimit();
	}

	public boolean isPrimaryThread()
	{
		return server.isPrimaryThread();
	}

	public String getMotd()
	{
		return server.getMotd();
	}

	public String getShutdownMessage()
	{
		return server.getShutdownMessage();
	}

	public Set<String> getListeningPluginChannels()
	{
		return server.getListeningPluginChannels();
	}

	protected final Server server;
}
