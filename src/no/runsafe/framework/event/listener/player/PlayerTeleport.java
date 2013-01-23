package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.EventEngine;
import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.event.player.IPlayerTeleportEvent;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.player.RunsafePlayerTeleportEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerTeleport extends EventRouterBase<IPlayerTeleportEvent, PlayerTeleportEvent>
{
	public PlayerTeleport(IOutput output, IScheduler scheduler, IPlayerTeleportEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(PlayerTeleportEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(PlayerTeleportEvent event)
	{
		handler.OnPlayerTeleport(new RunsafePlayerTeleportEvent(event));
		return true;
	}

	static class Factory implements EventRouterFactory
	{
		@Override
		public Class<? extends IRunsafeEvent> getInterface()
		{
			return IPlayerTeleportEvent.class;
		}

		@Override
		public Listener getListener (IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
		{
			return new PlayerTeleport(output, scheduler, (IPlayerTeleportEvent) subscriber);
		}
	}
}
