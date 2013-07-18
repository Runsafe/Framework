package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.player.IPlayerPortal;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public final class PlayerPortalEvent extends EventRouterBase<IPlayerPortal, org.bukkit.event.player.PlayerPortalEvent>
{
	PlayerPortalEvent(IOutput output, IScheduler scheduler, IPlayerPortal handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(org.bukkit.event.player.PlayerPortalEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(org.bukkit.event.player.PlayerPortalEvent event)
	{
		return handler.OnPlayerPortal(
			ObjectWrapper.convert((OfflinePlayer) event.getPlayer()),
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
