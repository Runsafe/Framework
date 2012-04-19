package no.runsafe.framework.server;

import org.bukkit.World;

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

	public World getRaw()
	{
		return this.world;
	}

	public int getMaxHeight()
	{
		return world.getMaxHeight();
	}

	private World world;
}
