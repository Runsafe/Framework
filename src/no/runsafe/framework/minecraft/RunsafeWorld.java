package no.runsafe.framework.minecraft;

import no.runsafe.framework.api.*;
import no.runsafe.framework.internal.Multiverse;
import no.runsafe.framework.internal.wrapper.BukkitWorld;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import javax.annotation.Nullable;

public class RunsafeWorld extends BukkitWorld implements IWorld
{
	public RunsafeWorld(World toWrap)
	{
		super(toWrap);
	}

	@Override
	public boolean equals(Object obj)
	{
		return obj instanceof IWorld && getName().equals(((IWorld) obj).getName());
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
	public IUniverse getUniverse()
	{
		return Multiverse.Get().getByWorld(this);
	}

	@Override
	public boolean isConnected(IWorld world)
	{
		return getUniverse().equals(world.getUniverse());
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
}
