package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.player.IPlayerDeathEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerDeathEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public final class PlayerDeath extends EventRouterBase<IPlayerDeathEvent, PlayerDeathEvent>
{
	PlayerDeath(IDebug output, IScheduler scheduler, IPlayerDeathEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(PlayerDeathEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(PlayerDeathEvent event)
	{
		handler.OnPlayerDeathEvent(new RunsafePlayerDeathEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IPlayerDeathEvent.class;
			}

			@Override
			public Listener getListener(IDebug output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PlayerDeath(output, scheduler, (IPlayerDeathEvent) subscriber);
			}
		};
	}
}
