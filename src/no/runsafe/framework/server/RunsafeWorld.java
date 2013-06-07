package no.runsafe.framework.server;

import no.runsafe.framework.server.entity.RunsafeEntity;
import no.runsafe.framework.wrapper.BukkitWorld;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.World;
import org.bukkit.entity.Entity;

public class RunsafeWorld extends BukkitWorld
{
	public RunsafeWorld(World toWrap)
	{
		super(toWrap);
	}

	public RunsafeWorld(String worldName)
	{
		super(RunsafeServer.Instance.getWorld(worldName).getRaw());
	}

	public boolean equals(RunsafeWorld world)
	{
		return getName().equals(world.getName());
	}

	public RunsafeEntity getEntityById(int id)
	{
		for (Entity entity : world.getEntities())
			if (entity.getEntityId() == id)
				return ObjectWrapper.convert(entity);
		return null;
	}
}
