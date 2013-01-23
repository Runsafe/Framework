package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.EventEngine;
import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.event.player.IPlayerKickEvent;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.player.RunsafePlayerKickEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public class PlayerKick extends EventRouterBase<IPlayerKickEvent, PlayerKickEvent>
{
	public PlayerKick(IOutput output, IScheduler scheduler, IPlayerKickEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(PlayerKickEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(PlayerKickEvent event)
	{
		handler.OnPlayerKick(new RunsafePlayerKickEvent(event));
		return true;
	}

	static class Factory implements EventRouterFactory
	{
		@Override
		public Class<? extends IRunsafeEvent> getInterface()
		{
			return IPlayerKickEvent.class;
		}

		@Override
		public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
		{
			return new PlayerKick(output, scheduler, (IPlayerKickEvent) subscriber);
		}
	}
}
