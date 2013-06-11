package no.runsafe.framework.minecraft;

import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.internal.wrapper.BukkitWorld;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
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
