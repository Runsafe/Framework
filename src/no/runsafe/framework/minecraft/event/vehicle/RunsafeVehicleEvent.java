package no.runsafe.framework.minecraft.event.vehicle;

import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.event.RunsafeCancellableEvent;
import no.runsafe.framework.minecraft.event.RunsafeEvent;
import org.bukkit.event.Event;
import org.bukkit.event.vehicle.VehicleEvent;

public class RunsafeVehicleEvent extends RunsafeEvent
{
	protected RunsafeVehicleEvent(VehicleEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public IEntity getVehicle()
	{
		return ObjectWrapper.convert(event.getVehicle());
	}

	private final VehicleEvent event;
}
