package no.runsafe.framework.minecraft;

import no.runsafe.framework.api.hook.IUniverseMapper;
import no.runsafe.framework.internal.HookEngine;
import no.runsafe.framework.internal.wrapper.BukkitWorld;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import java.util.List;

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

	public boolean isUniverse(String name)
	{
		return getUniverse().getName().equalsIgnoreCase(name);
	}

	public Universe getUniverse()
	{
		if (universe != null)
			return universe;
		List<IUniverseMapper> dataHooks = HookEngine.hookContainer.getComponents(IUniverseMapper.class);
		for (IUniverseMapper mapper : dataHooks)
		{
			String name = mapper.GetUniverse(getName());
			if (name != null)
			{
				universe = new Universe(name);
				return universe;
			}
		}
		return new Universe(getName());
	}

	public boolean IsConnected(RunsafeWorld world)
	{
		return getUniverse().getName().equals(world.getUniverse().getName());
	}

	public RunsafeLocation getLocation(Double x, Double y, Double z)
	{
		return getLocation(x, y, z, null, null);
	}

	public RunsafeLocation getLocation(Double x, Double y, Double z, Float yaw, Float pitch)
	{
		if (x == null || y == null || z == null)
			return null;

		if (yaw == null || pitch == null)
			return new RunsafeLocation(this, x, y, z);

		return new RunsafeLocation(this, x, y, z, yaw, pitch);
	}

	private Universe universe = null;
}
