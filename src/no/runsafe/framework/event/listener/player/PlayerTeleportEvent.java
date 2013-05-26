package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.event.player.IPlayerTeleport;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerTeleportEvent extends EventRouterBase<IPlayerTeleport, org.bukkit.event.player.PlayerTeleportEvent>
{
	protected PlayerTeleportEvent(IOutput output, IScheduler scheduler, IPlayerTeleport handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(org.bukkit.event.player.PlayerTeleportEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(org.bukkit.event.player.PlayerTeleportEvent event)
	{
		handler.OnPlayerTeleport(
			ObjectWrapper.convert(event.getPlayer()),
			ObjectWrapper.convert(event.getFrom()),
			ObjectWrapper.convert(event.getTo())
		);
		return true;
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
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PlayerTeleportEvent(output, scheduler, (IPlayerTeleport) subscriber);
			}
		};
	}
}
