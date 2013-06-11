package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.internal.wrapper.entity.BukkitVehicle;
import org.bukkit.entity.Vehicle;

public class RunsafeVehicle extends BukkitVehicle
{
	public RunsafeVehicle(Vehicle toWrap)
	{
		super(toWrap);
	}
}
