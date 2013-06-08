package no.runsafe.framework.wrapper;

import no.runsafe.framework.minecraft.Sound;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.entity.RunsafeEntity;
import no.runsafe.framework.server.entity.RunsafeFallingBlock;
import no.runsafe.framework.server.entity.RunsafeItem;
import no.runsafe.framework.server.item.RunsafeItemStack;
import no.runsafe.framework.server.player.RunsafePlayer;
import no.runsafe.framework.wrapper.metadata.RunsafeMetadata;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.List;

public abstract class BukkitWorld extends RunsafeMetadata
{

	public BukkitWorld(World toWrap)
	{
		super(toWrap);
		world = toWrap;
	}

	public String getName()
	{
		return world.getName();
	}

	public RunsafeBlock getBlockAt(RunsafeLocation location)
	{
		return new RunsafeBlock(world.getBlockAt(location.getRaw()));
	}

	public RunsafeBlock getBlockAt(int x, int y, int z)
	{
		return new RunsafeBlock(world.getBlockAt(x, y, z));
	}

	public int getBlockTypeIdAt(RunsafeLocation location)
	{
		return world.getBlockTypeIdAt(location.getRaw());
	}

	public int getBlockTypeIdAt(int x, int y, int z)
	{
		return world.getBlockTypeIdAt(x, y, z);
	}

	public RunsafeItem dropItem(RunsafeLocation location, RunsafeItemStack itemStack)
	{
		return new RunsafeItem((world.dropItem(location.getRaw(), itemStack.getRaw())));
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
		return this.world;
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

	public List<RunsafePlayer> getPlayers()
	{
		return ObjectWrapper.convert(world.getPlayers());
	}

	public List<RunsafeEntity> getEntities()
	{
		return ObjectWrapper.convert(world.getEntities());
	}

	public <T extends Entity> T spawn(RunsafeLocation location, Class<T> mob)
	{
		return this.world.spawn(location.getRaw(), mob);
	}

	public void playEffect(RunsafeLocation location, Effect effect, int data)
	{
		this.world.playEffect(location.getRaw(), effect, data);
	}

	public void playSound(RunsafeLocation location, Sound sound, float volume, float pitch)
	{
		this.world.playSound(location.getRaw(), sound.getSound(), volume, pitch);
	}

	protected final World world;
}
