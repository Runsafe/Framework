package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.player.IPlayerPortalEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerPortalEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

public final class Portal extends EventRouterBase<IPlayerPortalEvent, PlayerPortalEvent>
{
	Portal(IConsole output, IScheduler scheduler, IPlayerPortalEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(PlayerPortalEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(PlayerPortalEvent event)
	{
		handler.OnPlayerPortalEvent(new RunsafePlayerPortalEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IPlayerPortalEvent.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new Portal(output, scheduler, (IPlayerPortalEvent) subscriber);
			}
		};
	}
}
