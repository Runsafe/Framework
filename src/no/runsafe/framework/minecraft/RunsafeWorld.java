package no.runsafe.framework.minecraft;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.hook.IUniverseMapper;
import no.runsafe.framework.internal.HookEngine;
import no.runsafe.framework.internal.wrapper.BukkitWorld;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import javax.annotation.Nullable;
import java.util.List;

public class RunsafeWorld extends BukkitWorld implements IWorld
{
	public RunsafeWorld(World toWrap)
	{
		super(toWrap);
	}

	@SuppressWarnings("InstanceofInterfaces")
	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof RunsafeWorld && getName().equals(((BukkitWorld) obj).getName());
	}

	@Override
	public int hashCode()
	{
		return getName().hashCode();
	}

	@Override
	@Nullable
	public RunsafeEntity getEntityById(int id)
	{
		for (Entity entity : world.getEntities())
			if (entity.getEntityId() == id)
				return ObjectWrapper.convert(entity);
		return null;
	}

	@Override
	public boolean isUniverse(String name)
	{
		return getUniverse().getName().equalsIgnoreCase(name);
	}

	@Override
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

	@Override
	public boolean isConnected(IWorld world)
	{
		return getUniverse().getName().equals(world.getUniverse().getName());
	}

	@Override
	public ILocation getLocation(Double x, Double y, Double z)
	{
		return getLocation(x, y, z, null, null);
	}

	@Override
	@Nullable
	public ILocation getLocation(Double x, Double y, Double z, Float yaw, Float pitch)
	{
		if (x == null || y == null || z == null)
			return null;

		if (yaw == null || pitch == null)
			return new RunsafeLocation(this, x, y, z);

		return new RunsafeLocation(this, x, y, z, yaw, pitch);
	}

	@Override
	public boolean isWorld(IWorld world)
	{
		return getName().equals(world.getName());
	}

	private Universe universe;
}
