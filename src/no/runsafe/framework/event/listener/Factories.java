package no.runsafe.framework.event.listener;

public final class Factories
{
	public static void Register()
	{
		no.runsafe.framework.event.listener.block.Factories.Register();
		no.runsafe.framework.event.listener.entity.Factories.Register();
		no.runsafe.framework.event.listener.player.Factories.Register();
		no.runsafe.framework.event.listener.world.Factories.Register();
	}
}
