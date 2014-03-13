package no.runsafe.framework.minecraft.event.vehicle;

import no.runsafe.framework.api.entity.ILivingEntity;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.vehicle.VehicleEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class RunsafeVehicleExitEvent extends RunsafeCancellableVehicleEvent
{
	public RunsafeVehicleExitEvent(VehicleExitEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public ILivingEntity getExiter()
	{
		return ObjectWrapper.convert(event.getExited());
	}

	private final VehicleExitEvent event;
}
