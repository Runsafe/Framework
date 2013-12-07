package no.runsafe.framework.internal.wrapper;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.chunk.RunsafeChunk;
import org.bukkit.Location;
import org.bukkit.util.Vector;

@SuppressWarnings("InstanceMethodNamingConvention")
public abstract class BukkitLocation
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

	public RunsafeWorld getWorld()
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

	public BukkitLocation add(BukkitLocation vec)
	{
		return ObjectWrapper.convert(location.add(vec.location));
	}

	public BukkitLocation add(double x, double y, double z)
	{
		return ObjectWrapper.convert(location.add(x, y, z));
	}

	public BukkitLocation subtract(BukkitLocation vec)
	{
		return ObjectWrapper.convert(location.subtract(vec.location));
	}

	public BukkitLocation subtract(Vector vec)
	{
		return ObjectWrapper.convert(location.subtract(vec));
	}

	public BukkitLocation subtract(double x, double y, double z)
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

	public double distance(BukkitLocation location)
	{
		if (!location.getWorld().getName().equals(location.location.getWorld().getName()))
			return Double.NaN;

		return this.location.distance(location.location);
	}

	public double distanceSquared(BukkitLocation location)
	{
		return this.location.distanceSquared(location.location);
	}

	public BukkitLocation multiply(double factor)
	{
		return ObjectWrapper.convert(location.multiply(factor));
	}

	public BukkitLocation zero()
	{
		return ObjectWrapper.convert(location.zero());
	}

	protected final Location location;
}
