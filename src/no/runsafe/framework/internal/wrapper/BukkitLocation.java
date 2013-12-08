package no.runsafe.framework.internal.wrapper;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.chunk.RunsafeChunk;
import org.bukkit.Location;
import org.bukkit.util.Vector;

@SuppressWarnings("InstanceMethodNamingConvention")
public abstract class BukkitLocation implements IWrapper<Location>
{
	protected BukkitLocation(Location toWrap)
	{
		location = toWrap;
	}

	public double getX()
	{
		return location.getX();
	}

	public double getY()
	{
		return location.getY();
	}

	public double getZ()
	{
		return location.getZ();
	}

	public void setYaw(float yaw)
	{
		location.setYaw(yaw);
	}

	public void setPitch(float pitch)
	{
		location.setPitch(pitch);
	}

	public float getYaw()
	{
		return location.getYaw();
	}

	public float getPitch()
	{
		return location.getPitch();
	}

	public void setX(double x)
	{
		location.setX(x);
	}

	public void setY(double y)
	{
		location.setY(y);
	}

	public void setZ(double z)
	{
		location.setZ(z);
	}

	public IWorld getWorld()
	{
		return new RunsafeWorld(location.getWorld());
	}

	public int getBlockX()
	{
		return location.getBlockX();
	}

	public int getBlockY()
	{
		return location.getBlockY();
	}

	public int getBlockZ()
	{
		return location.getBlockZ();
	}

	@Override
	public Location getRaw()
	{
		return location;
	}

	public RunsafeChunk getChunk()
	{
		return ObjectWrapper.convert(location.getChunk());
	}

	public IBlock getBlock()
	{
		return ObjectWrapper.convert(location.getBlock());
	}

	public Vector getDirection()
	{
		return location.getDirection();
	}

	public ILocation add(ILocation vec)
	{
		return ObjectWrapper.convert(location.add((Location) ObjectUnwrapper.convert(vec)));
	}

	public ILocation add(double x, double y, double z)
	{
		return ObjectWrapper.convert(location.add(x, y, z));
	}

	public ILocation subtract(ILocation vec)
	{
		return ObjectWrapper.convert(location.subtract((Location) ObjectUnwrapper.convert(vec)));
	}

	public ILocation subtract(Vector vec)
	{
		return ObjectWrapper.convert(location.subtract(vec));
	}

	public ILocation subtract(double x, double y, double z)
	{
		return ObjectWrapper.convert(location.subtract(x, y, z));
	}

	public double length()
	{
		return location.length();
	}

	public double lengthSquared()
	{
		return location.lengthSquared();
	}

	public double distance(ILocation location)
	{
		if (!location.getWorld().getName().equals(((Location) ObjectUnwrapper.convert(location)).getWorld().getName()))
			return Double.NaN;

		return this.location.distance((Location) ObjectUnwrapper.convert(location));
	}

	public double distanceSquared(ILocation location)
	{
		return this.location.distanceSquared((Location) ObjectUnwrapper.convert(location));
	}

	public ILocation multiply(double factor)
	{
		return ObjectWrapper.convert(location.multiply(factor));
	}

	public ILocation zero()
	{
		return ObjectWrapper.convert(location.zero());
	}

	public Vector toVector()
	{
		return location.toVector();
	}

	protected final Location location;
}
