package no.runsafe.framework.internal.wrapper;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.LegacyMaterial;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.Sound;
import no.runsafe.framework.minecraft.entity.RunsafeFallingBlock;
import no.runsafe.framework.minecraft.entity.RunsafeItem;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import javax.annotation.Nonnull;
import java.util.List;

public abstract class BukkitWorld extends BukkitMetadata
{

	protected BukkitWorld(World toWrap)
	{
		super(toWrap);
		world = toWrap;
	}

	@Nonnull
	public String getName()
	{
		return world.getName();
	}

	@Nonnull
	public IBlock getBlockAt(ILocation location)
	{
		return ObjectWrapper.convert(world.getBlockAt((Location) ObjectUnwrapper.convert(location)));
	}

	@Nonnull
	public IBlock getBlockAt(int x, int y, int z)
	{
		return ObjectWrapper.convert(world.getBlockAt(x, y, z));
	}

	public int getBlockTypeIdAt(ILocation location)
	{
		return LegacyMaterial.getIdOf(world.getBlockAt((Location) ObjectUnwrapper.convert(location)).getType());
	}

	public int getBlockTypeIdAt(int x, int y, int z)
	{
		return LegacyMaterial.getIdOf(world.getBlockAt(x, y, z).getType());
	}

	@Nonnull
	public RunsafeItem dropItem(ILocation location, RunsafeMeta itemStack)
	{
		return new RunsafeItem(world.dropItem((Location) ObjectUnwrapper.convert(location), itemStack.getRaw()));
	}

	public void strikeLightning(ILocation location)
	{
		world.strikeLightning((Location) ObjectUnwrapper.convert(location));
	}

	public void createExplosion(ILocation location, float power, boolean setFire)
	{
		world.createExplosion((Location) ObjectUnwrapper.convert(location), power, setFire);
	}

	public void createExplosion(ILocation location, float power, boolean setFire, boolean breakBlocks)
	{
		world.createExplosion(location.getX(), location.getY(), location.getZ(), power, setFire, breakBlocks);
	}

	@SuppressWarnings("MethodWithTooManyParameters")
	public void createExplosion(double x, double y, double z, float power, boolean setFire, boolean breakBlocks)
	{
		world.createExplosion(x, y, z, power, setFire, breakBlocks);
	}

	public RunsafeFallingBlock spawnFallingBlock(ILocation location, Material material, Byte blockData)
	{
		return ObjectWrapper.convert(world.spawnFallingBlock((Location) ObjectUnwrapper.convert(location), material, blockData));
	}

	public RunsafeFallingBlock spawnFallingBlock(ILocation location, Item type)
	{
		return ObjectWrapper.convert(world.spawnFallingBlock((Location) ObjectUnwrapper.convert(location), type.getType(), (byte) Math.max(type.getData(), 0)));
	}

	@Override
	public World getRaw()
	{
		return world;
	}

	public int getMaxHeight()
	{
		return world.getMaxHeight();
	}

	@Nonnull
	public IEntity spawnCreature(ILocation location, String type)
	{
		return ObjectWrapper.convert(world.spawnEntity((Location) ObjectUnwrapper.convert(location), EntityType.fromName(type)));
	}

	@Deprecated
	@Nonnull
	public IEntity spawnCreature(ILocation location, int id)
	{
		return ObjectWrapper.convert(world.spawnEntity((Location) ObjectUnwrapper.convert(location), EntityType.fromId(id)));
	}

	public void strikeLightningEffect(ILocation location)
	{
		world.strikeLightningEffect((Location) ObjectUnwrapper.convert(location));
	}

	@Nonnull
	public List<IPlayer> getPlayers()
	{
		return ObjectWrapper.convert(world.getPlayers());
	}

	@Nonnull
	public List<IEntity> getEntities()
	{
		return ObjectWrapper.convert(world.getEntities());
	}

	public <T extends Entity> T spawn(ILocation location, Class<T> mob)
	{
		return world.spawn((Location) ObjectUnwrapper.convert(location), mob);
	}

	public void playEffect(ILocation location, Effect effect, int data)
	{
		world.playEffect((Location) ObjectUnwrapper.convert(location), effect, data);
	}

	public void playSound(ILocation location, Sound sound, float volume, float pitch)
	{
		world.playSound((Location) ObjectUnwrapper.convert(location), sound.getSound(), volume, pitch);
	}

	public boolean isNormal()
	{
		return world.getEnvironment() == World.Environment.NORMAL;
	}

	public boolean isNether()
	{
		return world.getEnvironment() == World.Environment.NETHER;

	}

	public boolean isTheEnd()
	{
		return world.getEnvironment() == World.Environment.THE_END;
	}

	public void setTime(long time)
	{
		world.setTime(time);
	}

	protected final World world;
}
