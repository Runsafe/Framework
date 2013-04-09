package no.runsafe.framework.server.entity;

import org.bukkit.entity.Vehicle;

public class RunsafeVehicle extends RunsafeEntity
{
	public RunsafeVehicle(Vehicle toWrap)
	{
		super(toWrap);
		vehicle = toWrap;
	}

	private final Vehicle vehicle;
}
