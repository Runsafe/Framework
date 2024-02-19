package no.runsafe.framework.internal.extension;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IUniverse;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.internal.brane.Multiverse;
import no.runsafe.framework.internal.wrapper.BukkitWorld;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

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

	@Nonnull
	@Override
	public IUniverse getUniverse()
	{
		return Objects.requireNonNull(Multiverse.getInstance().getByWorld(this));
	}

	@Override
	public boolean isConnected(IWorld world)
	{
		return getUniverse().equals(world.getUniverse());
	}

	@Nullable
	@Override
	public ILocation getLocation(Double x, Double y, Double z)
	{
		return getLocation(x, y, z, null, null);
	}

	@Nullable
	@Override
	public ILocation getLocation(Double x, Double y, Double z, Float yaw, Float pitch)
	{
		if (x == null || y == null || z == null)
			return null;

		if (yaw == null || pitch == null)
			return ObjectWrapper.convert(new Location(world, x, y, z));

		return ObjectWrapper.convert(new Location(world, x, y, z, yaw, pitch));
	}

	@Override
	public boolean isWorld(IWorld world)
	{
		return getName().equals(world.getName());
	}
}
