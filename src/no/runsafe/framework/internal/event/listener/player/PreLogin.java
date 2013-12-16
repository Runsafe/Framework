package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.player.IPlayerPreLoginEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerPreLoginEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public final class PreLogin extends EventRouterBase<IPlayerPreLoginEvent, AsyncPlayerPreLoginEvent>
{
	PreLogin(IConsole output, IScheduler scheduler, IPlayerPreLoginEvent handler)
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
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PreLogin(output, scheduler, (IPlayerPreLoginEvent) subscriber);
			}
		};
	}
}
