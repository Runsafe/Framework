package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.player.IPlayerInteractEntityEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerInteractEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public final class InteractEntity extends EventRouterBase<IPlayerInteractEntityEvent, PlayerInteractEntityEvent>
{
	InteractEntity(IConsole output, IScheduler scheduler, IPlayerInteractEntityEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(PlayerInteractEntityEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(PlayerInteractEntityEvent event)
	{
		handler.OnPlayerInteractEntityEvent(new RunsafePlayerInteractEntityEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IPlayerInteractEntityEvent.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new InteractEntity(output, scheduler, (IPlayerInteractEntityEvent) subscriber);
			}
		};
	}
}
