package no.runsafe.framework.internal.event.listener;

public final class Factories
{
	public static void Register()
	{
		if (isRegistered)
			return;
		no.runsafe.framework.internal.event.listener.block.Factories.Register();
		no.runsafe.framework.internal.event.listener.enchantment.Factories.Register();
		no.runsafe.framework.internal.event.listener.entity.Factories.Register();
		no.runsafe.framework.internal.event.listener.hanging.Factories.Register();
		no.runsafe.framework.internal.event.listener.inventory.Factories.Register();
		no.runsafe.framework.internal.event.listener.player.Factories.Register();
		no.runsafe.framework.internal.event.listener.world.Factories.Register();
		isRegistered = true;
	}

	private static boolean isRegistered = false;
}
