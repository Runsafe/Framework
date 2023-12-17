package no.runsafe.framework.api;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.api.server.*;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.inventory.RunsafeInventoryHolder;
import no.runsafe.framework.minecraft.inventory.RunsafeInventoryType;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IServer extends IPlayerProvider, IPlayerManager, IBroadcast, IWhitelistManager, IWorldManager
{
	boolean someoneHasPermission(String permission);

	List<IPlayer> getPlayersWithPermission(String permission);

	@Nullable
	<T extends Plugin> T getPlugin(String pluginName);

	void clearRecipes();

	boolean getAllowFlight();

	String getBukkitVersion();

	Map<String, String[]> getCommandAliases();

	long getConnectionThrottle();

	boolean getGenerateStructures();

	String getIp();

	int getMaxPlayers();

	String getName();

	boolean getOnlineMode();

	List<IPlayer> getOperators();

	int getPort();

	String getServerId();

	String getServerName();

	int getSpawnRadius();

	int getTicksPerAnimalSpawns();

	int getTicksPerMonsterSpawns();

	String getUpdateFolder();

	int getViewDistance();

	void reload();

	void resetRecipes();

	void savePlayers();

	void setSpawnRadius(int radius);

	void shutdown();

	RunsafeInventory createInventory(RunsafeInventoryHolder holder, int size, String name);

	RunsafeInventory createInventory(RunsafeInventoryHolder holder, int size);

	@Nullable
	RunsafeInventory createInventory(RunsafeInventoryHolder holder, RunsafeInventoryType type);

	void stop();

	boolean isHardcore();

	int getWaterAnimalSpawnLimit();

	int getAmbientSpawnLimit();

	int getMonsterSpawnLimit();

	int getAnimalSpawnLimit();

	boolean isPrimaryThread();

	String getMotd();

	String getShutdownMessage();

	Set<String> getListeningPluginChannels();

	void addRecipe(ShapedRecipe recipe);

	MapView getMap(short id);
}
