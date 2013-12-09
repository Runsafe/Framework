package no.runsafe.framework.api;

import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.inventory.RunsafeInventoryHolder;
import no.runsafe.framework.minecraft.inventory.RunsafeInventoryType;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nullable;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public interface IServer
{
	@Deprecated
	IDebug getDebugger();

	@Nullable
	IPlayer getPlayer(String playerName);

	@Nullable
	IPlayer getOnlinePlayer(IPlayer context, String playerName);

	@Nullable
	List<IPlayer> getOnlinePlayers(String playerName);

	@Nullable
	IPlayer getPlayerExact(String playerName);

	void banPlayer(IPlayer banner, IPlayer player, String reason);

	void kickPlayer(IPlayer kicker, IPlayer player, String reason);

	@Nullable
	IPlayer getKicker(String playerName);

	boolean someoneHasPermission(String permission);

	List<IPlayer> getPlayersWithPermission(String permission);

	@Nullable
	<T extends Plugin> T getPlugin(String pluginName);

	List<String> getOnlinePlayers(IPlayer context, String playerName);

	void banIP(String address);

	int broadcastMessage(String message, String permission);

	int broadcastMessage(String message);

	void clearRecipes();

	boolean getAllowEnd();

	boolean getAllowFlight();

	boolean getAllowNether();

	List<IPlayer> getBannedPlayers();

	String getBukkitVersion();

	Map<String, String[]> getCommandAliases();

	long getConnectionThrottle();

	boolean getGenerateStructures();

	String getIp();

	Set<String> getIpBans();

	int getMaxPlayers();

	String getName();

	@Nullable
	IPlayer getOfflinePlayerExact(String playerName);

	List<IPlayer> getOfflinePlayers();

	boolean getOnlineMode();

	List<IPlayer> getOnlinePlayers();

	List<IPlayer> getOperators();

	int getPort();

	String getServerId();

	String getServerName();

	int getSpawnRadius();

	int getTicksPerAnimalSpawns();

	int getTicksPerMonsterSpawns();

	String getUpdateFolder();

	int getViewDistance();

	List<IPlayer> getWhitelistedPlayers();

	@Nullable
	List<IPlayer> matchPlayer(String playerName);

	@Nullable
	IWorld getWorld(String worldName);

	@Nullable
	IWorld getWorld(UUID uid);

	List<IWorld> getWorlds();

	File getWorldContainer();

	String getWorldType();

	boolean hasWhitelist();

	void reload();

	void reloadWhitelist();

	void resetRecipes();

	void savePlayers();

	void setSpawnRadius(int radius);

	void setWhitelist(boolean value);

	void shutdown();

	boolean unloadWorld(String worldName, boolean save);

	boolean unloadWorld(IWorld world, boolean save);

	boolean useExactLoginLocation();

	RunsafeInventory createInventory(RunsafeInventoryHolder holder, int size, String name);

	RunsafeInventory createInventory(RunsafeInventoryHolder holder, int size);

	@Nullable
	RunsafeInventory createInventory(RunsafeInventoryHolder holder, RunsafeInventoryType type);

	void stop();

	void unbanIP(String ip);

	boolean isHardcore();

	int getWaterAnimalSpawnLimit();

	int getAmbientSpawnLimit();

	int getMonsterSpawnLimit();

	int getAnimalSpawnLimit();

	boolean isPrimaryThread();

	String getMotd();

	String getShutdownMessage();

	Set<String> getListeningPluginChannels();
}
