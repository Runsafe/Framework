package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IDebug;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.player.IPlayerQuitEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerQuitEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public final class PlayerQuit extends EventRouterBase<IPlayerQuitEvent, PlayerQuitEvent>
{
	PlayerQuit(IDebug output, IScheduler scheduler, IPlayerQuitEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(PlayerQuitEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(PlayerQuitEvent event)
	{
		handler.OnPlayerQuit(new RunsafePlayerQuitEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IPlayerQuitEvent.class;
			}

			@Override
			public Listener getListener(IDebug output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PlayerQuit(output, scheduler, (IPlayerQuitEvent) subscriber);
			}
		};
	}
}
