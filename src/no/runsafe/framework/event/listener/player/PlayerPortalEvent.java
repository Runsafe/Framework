package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.event.player.IPlayerPortal;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerPortalEvent extends EventRouterBase<IPlayerPortal, org.bukkit.event.player.PlayerPortalEvent>
{
	public PlayerPortalEvent(IOutput output, IScheduler scheduler, IPlayerPortal handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(org.bukkit.event.player.PlayerPortalEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(org.bukkit.event.player.PlayerPortalEvent event)
	{
		return handler.OnPlayerPortal(
			ObjectWrapper.convert(event.getPlayer()),
			ObjectWrapper.convert(event.getFrom()),
			ObjectWrapper.convert(event.getTo())
		);
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IPlayerPortal.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PlayerPortalEvent(output, scheduler, (IPlayerPortal) subscriber);
			}
		};
	}
}
