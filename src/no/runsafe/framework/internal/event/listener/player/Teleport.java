package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.player.IPlayerTeleportEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerTeleportEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public final class Teleport extends EventRouterBase<IPlayerTeleportEvent, PlayerTeleportEvent>
{
	Teleport(IConsole output, IScheduler scheduler, IPlayerTeleportEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(PlayerTeleportEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(PlayerTeleportEvent event)
	{
		handler.OnPlayerTeleport(new RunsafePlayerTeleportEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IPlayerTeleportEvent.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new Teleport(output, scheduler, (IPlayerTeleportEvent) subscriber);
			}
		};
	}
}
