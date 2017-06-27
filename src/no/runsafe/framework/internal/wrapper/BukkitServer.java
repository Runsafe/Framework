package no.runsafe.framework.internal.wrapper;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.inventory.RunsafeInventoryHolder;
import no.runsafe.framework.minecraft.inventory.RunsafeInventoryType;
import no.runsafe.framework.internal.extension.player.RunsafePlayer;
import no.runsafe.framework.text.ChatColour;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.map.MapView;

import javax.annotation.Nullable;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

public abstract class BukkitServer implements IWrapper<Server>
{
	protected BukkitServer(Server toWrap)
	{
		server = toWrap;
	}

	public void banIP(String address)
	{
		server.banIP(address);
	}

	public int broadcastMessage(String message, String permission)
	{
		if (message == null)
			return 0;
		return server.broadcast(ChatColour.ToMinecraft(message), permission);
	}

	public int broadcastMessage(String message)
	{
		if (message == null)
			return 0;
		return server.broadcastMessage(ChatColour.ToMinecraft(message));
	}

	public void clearRecipes()
	{
		server.clearRecipes();
	}

	public boolean getAllowEnd()
	{
		return server.getAllowEnd();
	}

	public boolean getAllowFlight()
	{
		return server.getAllowFlight();
	}

	public boolean getAllowNether()
	{
		return server.getAllowNether();
	}

	public List<IPlayer> getBannedPlayers()
	{
		return ObjectWrapper.convert(server.getBannedPlayers());
	}

	public String getBukkitVersion()
	{
		return server.getBukkitVersion();
	}

	public Map<String, String[]> getCommandAliases()
	{
		return server.getCommandAliases();
	}

	public long getConnectionThrottle()
	{
		return server.getConnectionThrottle();
	}

	public boolean getGenerateStructures()
	{
		return server.getGenerateStructures();
	}

	public String getIp()
	{
		return server.getIp();
	}

	public Set<String> getIpBans()
	{
		return server.getIPBans();
	}

	public Logger getLogger()
	{
		return server.getLogger();
	}

	public int getMaxPlayers()
	{
		return server.getMaxPlayers();
	}

	public String getName()
	{
		return server.getName();
	}

	public List<IPlayer> getOfflinePlayers()
	{
		return ObjectWrapper.convert(server.getOfflinePlayers());
	}

	public boolean getOnlineMode()
	{
		return server.getOnlineMode();
	}

	public List<IPlayer> getOnlinePlayers()
	{
		return ObjectWrapper.convert(server.getOnlinePlayers().toArray(new OfflinePlayer[server.getOnlinePlayers().size()]));
	}

	public List<IPlayer> getOperators()
	{
		return ObjectWrapper.convert(server.getOperators());
	}

	public int getPort()
	{
		return server.getPort();
	}

	public String getServerId()
	{
		return server.getServerId();
	}

	public String getServerName()
	{
		return server.getServerName();
	}

	public int getSpawnRadius()
	{
		return server.getSpawnRadius();
	}

	public int getTicksPerAnimalSpawns()
	{
		return server.getTicksPerAnimalSpawns();
	}

	public int getTicksPerMonsterSpawns()
	{
		return server.getTicksPerMonsterSpawns();
	}

	public String getUpdateFolder()
	{
		return server.getUpdateFolder();
	}

	public int getViewDistance()
	{
		return server.getViewDistance();
	}

	public List<IPlayer> getWhitelistedPlayers()
	{
		return ObjectWrapper.convert(server.getWhitelistedPlayers());
	}

	@Nullable
	public List<IPlayer> matchPlayer(String playerName)
	{
		if (playerName == null || playerName.isEmpty())
			return null;

		return ObjectWrapper.convert(server.matchPlayer(playerName));
	}

	@Nullable
	public IWorld getWorld(String worldName)
	{
		if (worldName == null || worldName.isEmpty())
			return null;

		return ObjectWrapper.convert(server.getWorld(worldName));
	}

	@Nullable
	public IWorld getWorld(UUID uid)
	{
		if (uid == null)
			return null;

		return ObjectWrapper.convert(server.getWorld(uid));
	}

	public List<IWorld> getWorlds()
	{
		return ObjectWrapper.convert(server.getWorlds());
	}

	public File getWorldContainer()
	{
		return server.getWorldContainer();
	}

	public String getWorldType()
	{
		return server.getWorldType();
	}

	public boolean hasWhitelist()
	{
		return server.hasWhitelist();
	}

	public void reload()
	{
		server.reload();
	}

	public void reloadWhitelist()
	{
		server.reloadWhitelist();
	}

	public void resetRecipes()
	{
		server.resetRecipes();
	}

	public void savePlayers()
	{
		server.savePlayers();
	}

	public void setSpawnRadius(int radius)
	{
		server.setSpawnRadius(radius);
	}

	public void setWhitelist(boolean value)
	{
		server.setWhitelist(value);
	}

	public void shutdown()
	{
		server.shutdown();
	}

	public boolean unloadWorld(String worldName, boolean save)
	{
		return !(worldName == null || worldName.isEmpty()) && server.unloadWorld(worldName, save);
	}

	public boolean unloadWorld(IWorld world, boolean save)
	{
		return world != null && unloadWorld(world.getName(), save);
	}

	public RunsafeInventory createInventory(RunsafeInventoryHolder holder, int size, String name)
	{
		if (name == null)
			return createInventory(holder, size);

		if (holder == null)
			return ObjectWrapper.convert(server.createInventory(null, size, name));

		return ObjectWrapper.convert(server.createInventory(holder.getRaw(), size, name));
	}

	public RunsafeInventory createInventory(RunsafeInventoryHolder holder, int size)
	{
		if (holder == null)
			return ObjectWrapper.convert(server.createInventory(null, size));

		return ObjectWrapper.convert(server.createInventory(holder.getRaw(), size));
	}

	@Nullable
	public RunsafeInventory createInventory(RunsafeInventoryHolder holder, RunsafeInventoryType type)
	{
		if (type == null)
			return null;

		if (holder == null)
			return ObjectWrapper.convert(server.createInventory(null, type.getRaw()));

		return ObjectWrapper.convert(server.createInventory(holder.getRaw(), type.getRaw()));
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

	public MapView getMap(short id)
	{
		return server.getMap(id);
	}

	@Override
	public Server getRaw()
	{
		return server;
	}

	protected final Server server;
}
