package no.runsafe.framework.event.listener;

public final class Registration
{
	public static void Run()
	{
		no.runsafe.framework.event.listener.block.Registration.Run();
		no.runsafe.framework.event.listener.entity.Registration.Run();
		no.runsafe.framework.event.listener.player.Registration.Run();
		no.runsafe.framework.event.listener.world.Registration.Run();
	}
}
