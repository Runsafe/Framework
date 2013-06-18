package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.event.player.IPlayerJoinEvent;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerJoinEvent;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class PlayerJoin extends EventRouterBase<IPlayerJoinEvent, PlayerJoinEvent>
{
	private PlayerJoin(IOutput output, IScheduler scheduler, IPlayerJoinEvent subscriber)
	{
		super(output, scheduler, subscriber);
	}

	// We have to put this here to get the annotation onto the method.
	@EventHandler
	@Override
	public void acceptEvent(PlayerJoinEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(PlayerJoinEvent event)
	{
		handler.OnPlayerJoinEvent(new RunsafePlayerJoinEvent(event));
		return true;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IPlayerJoinEvent.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PlayerJoin(output, scheduler, (IPlayerJoinEvent) subscriber);
			}
		};
	}
}
