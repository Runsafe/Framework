package no.runsafe.framework.internal.event.listener.vehicle;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.vehicle.IVehicleExit;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.vehicle.RunsafeVehicleExitEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;

public final class VehicleExit extends EventRouterBase<IVehicleExit, VehicleExitEvent>
{
	VehicleExit(IConsole output, IScheduler scheduler, IVehicleExit handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(VehicleExitEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(VehicleExitEvent event)
	{
		handler.OnVehicleExit(new RunsafeVehicleExitEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IVehicleExit.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new VehicleExit(output, scheduler, (IVehicleExit) subscriber);
			}
		};
	}
}
