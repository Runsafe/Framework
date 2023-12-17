package no.runsafe.framework.internal.event.listener;

public final class Factories
{
	private Factories()
	{
	}

	public static void Register()
	{
		if (registrationNeeded)
		{
			no.runsafe.framework.internal.event.listener.block.Factories.Register();
			no.runsafe.framework.internal.event.listener.enchantment.Factories.Register();
			no.runsafe.framework.internal.event.listener.entity.Factories.Register();
			no.runsafe.framework.internal.event.listener.hanging.Factories.Register();
			no.runsafe.framework.internal.event.listener.inventory.Factories.Register();
			no.runsafe.framework.internal.event.listener.player.Factories.Register();
			no.runsafe.framework.internal.event.listener.world.Factories.Register();
			no.runsafe.framework.internal.event.listener.vehicle.Factories.Register();
			registrationNeeded = false;
		}
	}

	private static boolean registrationNeeded = true;
}
