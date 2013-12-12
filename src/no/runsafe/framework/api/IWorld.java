package no.runsafe.framework.api;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.metadata.IMetadata;
import no.runsafe.framework.api.player.IPlayer;
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

	ILocation getLocation(Double x, Double y, Double z);

	@Nullable
	ILocation getLocation(Double x, Double y, Double z, Float yaw, Float pitch);

	boolean isWorld(IWorld world);

	String getName();

	IBlock getBlockAt(ILocation location);

	IBlock getBlockAt(int x, int y, int z);

	int getBlockTypeIdAt(ILocation location);

	int getBlockTypeIdAt(int x, int y, int z);

	RunsafeItem dropItem(ILocation location, RunsafeMeta itemStack);

	void strikeLightning(ILocation location);

	void createExplosion(ILocation location, float power, boolean setFire);

	void createExplosion(ILocation location, float power, boolean setFire, boolean breakBlocks);

	int getMaxHeight();

	IEntity spawnCreature(ILocation location, String type);

	IEntity spawnCreature(ILocation location, int id);

	void strikeLightningEffect(ILocation location);

	List<IPlayer> getPlayers();

	List<IEntity> getEntities();

	void playSound(ILocation location, Sound sound, float volume, float pitch);

	boolean isNormal();

	boolean isNether();

	boolean isTheEnd();

	void setTime(long time);
}
