package no.runsafe.framework.minecraft;

import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.BukkitLocation;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.packets.PacketWorldParticles;
import no.runsafe.framework.minecraft.packets.WorldParticleOffset;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("NumericCastThatLosesPrecision")
public class RunsafeLocation extends BukkitLocation
{
	public RunsafeLocation(Location toWrap)
	{
		super(toWrap);
	}

	public RunsafeLocation(IWorld world, double x, double y, double z)
	{
		super(new Location((World) ObjectUnwrapper.convert(world), x, y, z));
	}

	@SuppressWarnings("ConstructorWithTooManyParameters")
	public RunsafeLocation(IWorld world, double x, double y, double z, float yaw, float pitch)
	{
		super(new Location((World) ObjectUnwrapper.convert(world), x, y, z, yaw, pitch));
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
		if (x > 0) incrementX(x);
		else decrementX(x);
		if (y > 0) incrementY(y);
		else decrementY(y);
		if (z > 0) incrementZ(z);
		else decrementZ(z);
	}

	@SuppressWarnings("LocalVariableOfConcreteClass")
	public List<IPlayer> getPlayersInRange(double range)
	{
		List<IPlayer> allPlayers = getWorld().getPlayers();
		List<IPlayer> players = new ArrayList<IPlayer>(allPlayers.size());

		for (IPlayer player : allPlayers)
		{
			RunsafeLocation playerLocation = player.getLocation();
			if (playerLocation != null && playerLocation.distance(this) <= range)
				players.add(player);
		}

		return players;
	}

	public void playEffect(WorldEffect effect, int speed, int amount, int range)
	{
		playEffect(effect, new WorldParticleOffset(), speed, amount, range);
	}

	@SuppressWarnings("LocalVariableOfConcreteClass")
	public void playEffect(WorldEffect effect, WorldParticleOffset offset, int speed, int amount, int range)
	{
		PacketWorldParticles packet = new PacketWorldParticles(effect, this, offset, speed, amount);
		for (IPlayer player : getPlayersInRange(range))
			packet.send(player);
	}

	public Vector toVector()
	{
		return location.toVector();
	}
}
