package no.runsafe.framework.world;

import org.bukkit.World;

public class RunsafeWorld {

	public RunsafeWorld(World toWrap)
	{
		bukkitWorld = toWrap;
	}
	
	public String getName()
	{
		return bukkitWorld.getName();
	}
	
	private World bukkitWorld;
}
