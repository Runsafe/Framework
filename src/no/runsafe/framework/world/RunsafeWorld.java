package no.runsafe.framework.world;

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

	public World getRaw()
	{
		return world;
	}

	private World world;
}
