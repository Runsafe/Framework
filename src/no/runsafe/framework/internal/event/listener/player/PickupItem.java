package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.player.IPlayerPickupItemEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerPickupItemEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public final class PickupItem extends EventRouterBase<IPlayerPickupItemEvent, PlayerPickupItemEvent>
{
	PickupItem(IConsole output, IScheduler scheduler, IPlayerPickupItemEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(PlayerPickupItemEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(PlayerPickupItemEvent event)
	{
		handler.OnPlayerPickupItemEvent(new RunsafePlayerPickupItemEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IPlayerPickupItemEvent.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PickupItem(output, scheduler, (IPlayerPickupItemEvent) subscriber);
			}
		};
	}
}
