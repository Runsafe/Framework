package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import org.bukkit.entity.Vehicle;

public abstract class BukkitVehicle extends RunsafeEntity
{
	protected BukkitVehicle(Vehicle toWrap)
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
