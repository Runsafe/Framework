package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.EventEngine;
import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.event.player.IPlayerLoginEvent;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.player.RunsafePlayerLoginEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLogin extends EventRouterBase<IPlayerLoginEvent, PlayerLoginEvent>
{
	public PlayerLogin(IOutput output, IScheduler scheduler, IPlayerLoginEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(PlayerLoginEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(PlayerLoginEvent event)
	{
		handler.OnPlayerLogin(new RunsafePlayerLoginEvent(event));
		return true;
	}

	static class Factory implements EventRouterFactory
	{
		@Override
		public Class<? extends IRunsafeEvent> getInterface()
		{
			return IPlayerLoginEvent.class;
		}

		@Override
		public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
		{
			return new PlayerLogin(output, scheduler, (IPlayerLoginEvent) subscriber);
		}
	}
}
