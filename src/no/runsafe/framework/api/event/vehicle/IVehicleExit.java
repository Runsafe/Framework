package no.runsafe.framework.api.event.vehicle;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.vehicle.RunsafeVehicleExitEvent;

public interface IVehicleExit extends IRunsafeEvent
{
	void OnVehicleExit(RunsafeVehicleExitEvent event);
}
