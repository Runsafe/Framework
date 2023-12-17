package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.player.IPlayerInteractEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerInteractEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public final class Interact extends EventRouterBase<IPlayerInteractEvent, PlayerInteractEvent>
{
	Interact(IConsole output, IScheduler scheduler, IPlayerInteractEvent handler)
	{
		super(output, scheduler, handler);
	}

	@Override
	@EventHandler
	public void acceptEvent(PlayerInteractEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(PlayerInteractEvent event)
	{
		handler.OnPlayerInteractEvent(new RunsafePlayerInteractEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IPlayerInteractEvent.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new Interact(output, scheduler, (IPlayerInteractEvent) subscriber);
			}
		};
	}
}
