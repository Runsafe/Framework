package no.runsafe.framework.internal.event.listener.vehicle;

import no.runsafe.framework.internal.event.BukkitEventMapper;

public final class Factories
{
	private Factories() {}

	public static void Register()
	{
		BukkitEventMapper.Register(VehicleExit.Factory());
	}
}
