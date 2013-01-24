package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.event.player.IPlayerPreLoginEvent;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.player.RunsafePlayerPreLoginEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public final class PlayerPreLogin extends EventRouterBase<IPlayerPreLoginEvent, AsyncPlayerPreLoginEvent>
{
	public PlayerPreLogin(IOutput output, IScheduler scheduler, IPlayerPreLoginEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(AsyncPlayerPreLoginEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(AsyncPlayerPreLoginEvent event)
	{
		handler.OnBeforePlayerLogin(new RunsafePlayerPreLoginEvent(event));
		return true;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IPlayerPreLoginEvent.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PlayerPreLogin(output, scheduler, (IPlayerPreLoginEvent) subscriber);
			}
		};
	}
}
