package no.runsafe.framework.api;

import net.minecraft.server.v1_7_R1.ItemBlock;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.metadata.IMetadata;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.Sound;
import no.runsafe.framework.minecraft.entity.RunsafeItem;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.Effect;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public interface IWorld extends IMetadata
{
	@Nullable
	IEntity getEntityById(int id);

	boolean isUniverse(String name);

	@Nonnull
	IUniverse getUniverse();

	boolean isConnected(IWorld world);

	@Nullable
	ILocation getLocation(Double x, Double y, Double z);

	@Nullable
	ILocation getLocation(Double x, Double y, Double z, Float yaw, Float pitch);

	boolean isWorld(IWorld world);

	@Nonnull
	String getName();

	@Nonnull
	IBlock getBlockAt(ILocation location);

	@Nonnull
	IBlock getBlockAt(int x, int y, int z);

	int getBlockTypeIdAt(ILocation location);

	int getBlockTypeIdAt(int x, int y, int z);

	@Nonnull
	RunsafeItem dropItem(ILocation location, RunsafeMeta itemStack);

	void strikeLightning(ILocation location);

	void createExplosion(ILocation location, float power, boolean setFire);

	void createExplosion(ILocation location, float power, boolean setFire, boolean breakBlocks);

	int getMaxHeight();

	@Nonnull
	IEntity spawnCreature(ILocation location, String type);

	@Nonnull
	@Deprecated
	IEntity spawnCreature(ILocation location, int id);

	IEntity spawnFallingBlock(ILocation location, Item type);

	void strikeLightningEffect(ILocation location);

	@Nonnull
	List<IPlayer> getPlayers();

	@Nonnull
	List<IEntity> getEntities();

	void playSound(ILocation location, Sound sound, float volume, float pitch);

	boolean isNormal();

	boolean isNether();

	boolean isTheEnd();

	void setTime(long time);

	void playEffect(ILocation location, Effect effect, int data);

	ILocation getSpawnLocation();

	int getHighestBlockYAt(int x, int z);

	int getHighestBlockYAt(ILocation location);

	IBlock getHighestBlockAt(int x, int z);

	IBlock getHighestBlockAt(ILocation location);
}
