package no.runsafe.framework.api;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.metadata.IMetadata;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.Sound;
import no.runsafe.framework.minecraft.Universe;
import no.runsafe.framework.minecraft.entity.RunsafeItem;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;

import javax.annotation.Nullable;
import java.util.List;

public interface IWorld extends IMetadata
{
	@Nullable
	IEntity getEntityById(int id);

	boolean isUniverse(String name);

	Universe getUniverse();

	boolean isConnected(IWorld world);

	RunsafeLocation getLocation(Double x, Double y, Double z);

	@Nullable
	RunsafeLocation getLocation(Double x, Double y, Double z, Float yaw, Float pitch);

	boolean isWorld(IWorld world);

	String getName();

	IBlock getBlockAt(RunsafeLocation location);

	IBlock getBlockAt(int x, int y, int z);

	int getBlockTypeIdAt(RunsafeLocation location);

	int getBlockTypeIdAt(int x, int y, int z);

	RunsafeItem dropItem(RunsafeLocation location, RunsafeMeta itemStack);

	void strikeLightning(RunsafeLocation location);

	void createExplosion(RunsafeLocation location, float power, boolean setFire);

	void createExplosion(RunsafeLocation location, float power, boolean setFire, boolean breakBlocks);

	int getMaxHeight();

	IEntity spawnCreature(RunsafeLocation location, String type);

	IEntity spawnCreature(RunsafeLocation location, int id);

	void strikeLightningEffect(RunsafeLocation location);

	List<IPlayer> getPlayers();

	List<IEntity> getEntities();

	void playSound(RunsafeLocation location, Sound sound, float volume, float pitch);
}
