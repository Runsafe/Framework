package no.runsafe.framework.internal.wrapper;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.Sound;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.entity.RunsafeFallingBlock;
import no.runsafe.framework.minecraft.entity.RunsafeItem;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.internal.wrapper.metadata.BukkitMetadata;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.List;

public abstract class BukkitWorld extends BukkitMetadata implements IWrapper<World>
{

	protected BukkitWorld(World toWrap)
	{
		super(toWrap);
		world = toWrap;
	}

	public String getName()
	{
		return world.getName();
	}

	public IBlock getBlockAt(RunsafeLocation location)
	{
		return ObjectWrapper.convert(world.getBlockAt(location.getRaw()));
	}

	public IBlock getBlockAt(int x, int y, int z)
	{
		return ObjectWrapper.convert(world.getBlockAt(x, y, z));
	}

	public int getBlockTypeIdAt(RunsafeLocation location)
	{
		return world.getBlockTypeIdAt(location.getRaw());
	}

	public int getBlockTypeIdAt(int x, int y, int z)
	{
		return world.getBlockTypeIdAt(x, y, z);
	}

	public RunsafeItem dropItem(RunsafeLocation location, RunsafeMeta itemStack)
	{
		return new RunsafeItem(world.dropItem(location.getRaw(), itemStack.getRaw()));
	}

	public void strikeLightning(RunsafeLocation location)
	{
		world.strikeLightning(location.getRaw());
	}

	public void createExplosion(RunsafeLocation location, float power, boolean setFire)
	{
		world.createExplosion(location.getRaw(), power, setFire);
	}

	public void createExplosion(RunsafeLocation location, float power, boolean setFire, boolean breakBlocks)
	{
		world.createExplosion(location.getX(), location.getY(), location.getZ(), power, setFire, breakBlocks);
	}

	@SuppressWarnings("MethodWithTooManyParameters")
	public void createExplosion(double x, double y, double z, float power, boolean setFire, boolean breakBlocks)
	{
		world.createExplosion(x, y, z, power, setFire, breakBlocks);
	}

	public RunsafeFallingBlock spawnFallingBlock(RunsafeLocation location, Material material, Byte blockData)
	{
		return ObjectWrapper.convert(world.spawnFallingBlock(location.getRaw(), material, blockData));
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

	public RunsafeEntity spawnCreature(RunsafeLocation location, String type)
	{
		return ObjectWrapper.convert(world.spawnEntity(location.getRaw(), EntityType.fromName(type)));
	}

	public RunsafeEntity spawnCreature(RunsafeLocation location, int id)
	{
		return ObjectWrapper.convert(world.spawnEntity(location.getRaw(), EntityType.fromId(id)));
	}

	public void strikeLightningEffect(RunsafeLocation location)
	{
		world.strikeLightningEffect(location.getRaw());
	}

	public List<IPlayer> getPlayers()
	{
		return ObjectWrapper.convert(world.getPlayers());
	}

	public List<RunsafeEntity> getEntities()
	{
		return ObjectWrapper.convert(world.getEntities());
	}

	public <T extends Entity> T spawn(RunsafeLocation location, Class<T> mob)
	{
		return world.spawn(location.getRaw(), mob);
	}

	public void playEffect(RunsafeLocation location, Effect effect, int data)
	{
		world.playEffect(location.getRaw(), effect, data);
	}

	public void playSound(RunsafeLocation location, Sound sound, float volume, float pitch)
	{
		world.playSound(location.getRaw(), sound.getSound(), volume, pitch);
	}

	protected final World world;
}
