package no.runsafe.framework.wrapper.entity;

import no.runsafe.framework.server.entity.RunsafeEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Vehicle;

public abstract class BukkitVehicle extends RunsafeEntity
{
	public BukkitVehicle(Vehicle toWrap)
	{
		super(toWrap);
		vehicle = toWrap;
	}

	@Override
	public Vehicle getRaw()
	{
		return vehicle;
	}

	protected final Vehicle vehicle;
}
