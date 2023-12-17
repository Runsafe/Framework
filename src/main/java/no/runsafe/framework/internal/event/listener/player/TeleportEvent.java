package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.player.IPlayerTeleport;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public final class TeleportEvent extends EventRouterBase<IPlayerTeleport, PlayerTeleportEvent>
{
	TeleportEvent(IConsole output, IScheduler scheduler, IPlayerTeleport handler)
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
		return !handler.OnPlayerTeleport(
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
				return IPlayerTeleport.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new TeleportEvent(output, scheduler, (IPlayerTeleport) subscriber);
			}
		};
	}
}
