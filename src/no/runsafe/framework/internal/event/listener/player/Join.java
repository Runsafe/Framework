package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.event.player.IPlayerJoinEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerJoinEvent;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public final class Join extends EventRouterBase<IPlayerJoinEvent, PlayerJoinEvent>
{
	Join(IConsole output, IScheduler scheduler, IPlayerJoinEvent subscriber)
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
		return false;
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
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new Join(output, scheduler, (IPlayerJoinEvent) subscriber);
			}
		};
	}
}
