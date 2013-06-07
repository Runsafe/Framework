package no.runsafe.framework.server.entity;

import no.runsafe.framework.wrapper.entity.BukkitVehicle;
import org.bukkit.entity.Vehicle;

public class RunsafeVehicle extends BukkitVehicle
{
	public RunsafeVehicle(Vehicle toWrap)
	{
		super(toWrap);
	}
}
