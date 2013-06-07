package no.runsafe.framework.wrapper.entity;

import no.runsafe.framework.server.entity.RunsafeEntity;
import org.bukkit.entity.Vehicle;

public class BukkitVehicle extends RunsafeEntity
{
	public BukkitVehicle(Vehicle toWrap)
	{
		super(toWrap);
		vehicle = toWrap;
	}

	protected final Vehicle vehicle;
}
