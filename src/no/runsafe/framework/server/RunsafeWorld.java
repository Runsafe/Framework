package no.runsafe.framework.server;

import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.entity.RunsafeEntity;
import no.runsafe.framework.server.item.RunsafeItem;
import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.World;
import org.bukkit.entity.EntityType;

public class RunsafeWorld
{
	public RunsafeWorld(World toWrap)
	{
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

	public World getRaw()
	{
		return this.world;
	}

	public int getMaxHeight()
	{
		return world.getMaxHeight();
	}

    public RunsafeEntity spawnCreature(RunsafeLocation location, EntityType entityType)
    {
        return new RunsafeEntity(world.spawnCreature(location.getRaw(), entityType));
    }

	private World world;
}
