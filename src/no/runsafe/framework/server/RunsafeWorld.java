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

    public World getRaw()
    {
        return this.world;
    }

	private World world;
}
