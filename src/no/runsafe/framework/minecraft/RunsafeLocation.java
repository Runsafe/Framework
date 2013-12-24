package no.runsafe.framework.minecraft;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.BukkitLocation;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class RunsafeLocation extends BukkitLocation implements ILocation
{
	public RunsafeLocation(Location toWrap)
	{
		super(toWrap);
	}

	@Override
	public ILocation findTop()
	{
		Location target = location.getWorld().getHighestBlockAt(location).getLocation();
		target.setPitch(location.getPitch());
		target.setYaw(location.getYaw());
		target.setX(location.getX());
		target.setZ(location.getZ());
		return ObjectWrapper.convert(target);
	}

	@Override
	public void incrementX(double x)
	{
		setX(getX() + x);
	}

	@Override
	public void incrementY(double y)
	{
		setY(getY() + y);
	}

	@Override
	public void incrementZ(double z)
	{
		setZ(getZ() + z);
	}

	@Override
	public void decrementX(double x)
	{
		setX(getX() - x);
	}

	@Override
	public void decrementY(double y)
	{
		setY(getY() - y);
	}

	@Override
	public void decrementZ(double z)
	{
		setZ(getZ() - z);
	}

	@Override
	public void playSound(Sound sound)
	{
		playSound(sound, 1, 1);
	}

	@Override
	public void playSound(Sound sound, float volume, float pitch)
	{
		location.getWorld().playSound(location, sound.getSound(), volume, pitch);
	}

	@Override
	public String toString()
	{
		return String.format("world: %s X: %s Y: %s Z: %s", getWorld().getName(), getX(), getY(), getZ());
	}

	@Override
	public void offset(double x, double y, double z)
	{
		setX(getX() + x);
		setY(getY() + y);
		setZ(getZ() + z);
	}

	@Override
	public List<IPlayer> getPlayersInRange(double range)
	{
		List<IPlayer> allPlayers = getWorld().getPlayers();
		List<IPlayer> players = new ArrayList<IPlayer>(allPlayers.size());

		for (IPlayer player : allPlayers)
		{
			ILocation playerLocation = player.getLocation();
			if (playerLocation != null && playerLocation.distance(this) <= range)
				players.add(player);
		}

		return players;
	}
}
