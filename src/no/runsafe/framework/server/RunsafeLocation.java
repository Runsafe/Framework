package no.runsafe.framework.server;

import no.runsafe.framework.minecraft.Sound;
import no.runsafe.framework.wrapper.BukkitLocation;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.Location;

public class RunsafeLocation extends BukkitLocation
{
	public RunsafeLocation(Location toWrap)
	{
		super(toWrap);
	}

	public RunsafeLocation(RunsafeWorld world, double x, double y, double z)
	{
		super(new Location(world.getRaw(), x, y, z));
	}

	public RunsafeLocation(RunsafeWorld world, double x, double y, double z, float yaw, float pitch)
	{
		super(new Location(world.getRaw(), x, y, z, yaw, pitch));
	}

	public RunsafeLocation top()
	{
		Location target = location.getWorld().getHighestBlockAt(location).getLocation();
		target.setPitch(location.getPitch());
		target.setYaw(location.getYaw());
		target.setX(location.getX());
		target.setZ(location.getZ());
		return ObjectWrapper.convert(target);
	}

	public void incrementX(double x)
	{
		this.setX(this.getX() + x);
	}

	public void incrementY(double y)
	{
		this.setY(this.getY() + y);
	}

	public void incrementZ(double z)
	{
		this.setZ(this.getZ() + z);
	}

	public void decrementX(double x)
	{
		this.setX(this.getX() - x);
	}

	public void decrementY(double y)
	{
		this.setY(this.getY() - y);
	}

	public void decrementZ(double z)
	{
		this.setZ(this.getZ() - z);
	}

	public void Play(Sound sound)
	{
		Play(sound, 1, 1);
	}

	public void Play(Sound sound, float volume, float pitch)
	{
		location.getWorld().playSound(location, sound.getSound(), volume, pitch);
	}

	@Override
	public String toString()
	{
		return String.format("world: %s X: %s Y: %s Z: %s", this.getWorld().getName(), this.getX(), this.getY(), this.getZ());
	}

	public void offset(double x, double y, double z)
	{
		if (x > 0) this.incrementX(x); else this.decrementX(x);
		if (y > 0) this.incrementY(y); else this.decrementY(y);
		if (z > 0) this.incrementZ(z); else this.decrementZ(z);
	}
}
