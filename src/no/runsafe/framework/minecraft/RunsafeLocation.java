package no.runsafe.framework.minecraft;

import no.runsafe.framework.internal.packets.PacketHelper;
import no.runsafe.framework.internal.wrapper.BukkitLocation;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.Random;

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

	@SuppressWarnings("ConstructorWithTooManyParameters")
	public RunsafeLocation(RunsafeWorld world, double x, double y, double z, float yaw, float pitch)
	{
		super(new Location(world.getRaw(), x, y, z, yaw, pitch));
	}

	@SuppressWarnings("InstanceMethodNamingConvention")
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
		setX(getX() + x);
	}

	public void incrementY(double y)
	{
		setY(getY() + y);
	}

	public void incrementZ(double z)
	{
		setZ(getZ() + z);
	}

	public void decrementX(double x)
	{
		setX(getX() - x);
	}

	public void decrementY(double y)
	{
		setY(getY() - y);
	}

	public void decrementZ(double z)
	{
		setZ(getZ() - z);
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
		return String.format("world: %s X: %s Y: %s Z: %s", getWorld().getName(), getX(), getY(), getZ());
	}

	public void offset(double x, double y, double z)
	{
		if (x > 0) incrementX(x); else decrementX(x);
		if (y > 0) incrementY(y); else decrementY(y);
		if (z > 0) incrementZ(z); else decrementZ(z);
	}

	public void playEffect(WorldEffect effect, int speed, int amount, int range)
	{
		this.playEffect(effect, random.nextFloat(), random.nextFloat(), random.nextFloat(), speed, amount, range);
	}

	public void playEffect(WorldEffect effect, float offsetX, float offsetY, float offsetZ, int speed, int amount, int range)
	{
		try
		{
			HashMap<String, Object> data = new HashMap<String, Object>();
			data.put("a", effect.getName());
			data.put("b", (float) getX());
			data.put("c", (float) getY());
			data.put("d", (float) getZ());
			data.put("e", offsetX);
			data.put("f", offsetY);
			data.put("g", offsetZ);
			data.put("h", speed);
			data.put("i", amount);

			Object packet = PacketHelper.stuffPacket(PacketHelper.getPacket("Packet63WorldParticles"), data);

			for (RunsafePlayer player : this.getWorld().getPlayers())
				if (player.getLocation().distance(this) <= range)
					player.sendPacket(packet);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private Random random = new Random();
}
