package no.runsafe.framework.wrapper;

import no.runsafe.framework.server.RunsafeWorld;
import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.chunk.RunsafeChunk;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public abstract class BukkitLocation
{
	public BukkitLocation(Location toWrap)
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
		this.location.setX(x);
	}

	public void setY(double y)
	{
		this.location.setY(y);
	}

	public void setZ(double z)
	{
		this.location.setZ(z);
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
		return ObjectWrapper.convert(this.location.getChunk());
	}

	public RunsafeBlock getBlock()
	{
		return ObjectWrapper.convert(this.location.getBlock());
	}

	public Vector getDirection()
	{
		return this.location.getDirection();
	}

	public BukkitLocation add(BukkitLocation vec)
	{
		return ObjectWrapper.convert(this.location.add(vec.getRaw()));
	}

	public BukkitLocation add(double x, double y, double z)
	{
		return ObjectWrapper.convert(this.location.add(x, y, z));
	}

	public BukkitLocation subtract(BukkitLocation vec)
	{
		return ObjectWrapper.convert(this.location.subtract(vec.getRaw()));
	}

	public BukkitLocation subtract(Vector vec)
	{
		return ObjectWrapper.convert(this.location.subtract(vec));
	}

	public BukkitLocation subtract(double x, double y, double z)
	{
		return ObjectWrapper.convert(this.location.subtract(x, y, z));
	}

	public double length()
	{
		return this.location.length();
	}

	public double lengthSquared()
	{
		return this.location.lengthSquared();
	}

	public double distance(BukkitLocation location)
	{
		if (!location.getWorld().getName().equals(location.getRaw().getWorld().getName()))
			return Double.NaN;

		return this.location.distance(location.getRaw());
	}

	public double distanceSquared(BukkitLocation location)
	{
		return this.location.distanceSquared(location.getRaw());
	}

	public BukkitLocation multiply(double m)
	{
		return ObjectWrapper.convert(this.location.multiply(m));
	}

	public BukkitLocation zero()
	{
		return ObjectWrapper.convert(this.location.zero());
	}

	protected final Location location;
}
