package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.player.IPlayerPreLoginEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerPreLoginEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public final class PlayerPreLogin extends EventRouterBase<IPlayerPreLoginEvent, AsyncPlayerPreLoginEvent>
{
	PlayerPreLogin(IDebug output, IScheduler scheduler, IPlayerPreLoginEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(AsyncPlayerPreLoginEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(AsyncPlayerPreLoginEvent event)
	{
		handler.OnBeforePlayerLogin(new RunsafePlayerPreLoginEvent(event));
		return false;
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
			public Listener getListener(IDebug output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PlayerPreLogin(output, scheduler, (IPlayerPreLoginEvent) subscriber);
			}
		};
	}
}
