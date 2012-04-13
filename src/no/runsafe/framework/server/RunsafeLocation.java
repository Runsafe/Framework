package no.runsafe.framework.server;

import org.bukkit.Location;

public class RunsafeLocation
{
	public RunsafeLocation(Location toWrap)
	{
		location = toWrap;
	}

	public Location getRaw()
	{
		return location;
	}

	private Location location;
}
