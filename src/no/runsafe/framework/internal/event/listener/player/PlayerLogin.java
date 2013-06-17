package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.event.player.IPlayerLoginEvent;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerLoginEvent;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public final class PlayerLogin extends EventRouterBase<IPlayerLoginEvent, PlayerLoginEvent>
{
	public PlayerLogin(IOutput output, IScheduler scheduler, IPlayerLoginEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(PlayerLoginEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(PlayerLoginEvent event)
	{
		handler.OnPlayerLogin(new RunsafePlayerLoginEvent(event));
		return true;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
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
		};
	}
}
