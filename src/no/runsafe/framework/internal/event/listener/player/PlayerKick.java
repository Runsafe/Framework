package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.event.player.IPlayerKickEvent;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerKickEvent;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;

public final class PlayerKick extends EventRouterBase<IPlayerKickEvent, PlayerKickEvent>
{
	public PlayerKick(IOutput output, IScheduler scheduler, IPlayerKickEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(PlayerKickEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(PlayerKickEvent event)
	{
		handler.OnPlayerKick(new RunsafePlayerKickEvent(event));
		return true;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
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
		};
	}
}
