package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.EventEngine;
import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.event.player.IPlayerInteractEvent;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.player.RunsafePlayerInteractEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract extends EventRouterBase<IPlayerInteractEvent, PlayerInteractEvent>
{
	public PlayerInteract(IOutput output, IScheduler scheduler, IPlayerInteractEvent handler)
	{
		super(output, scheduler, handler);
	}

	@Override
	@EventHandler
	public void AcceptEvent(PlayerInteractEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(PlayerInteractEvent event)
	{
		handler.OnPlayerInteractEvent(new RunsafePlayerInteractEvent(event));
		return true;
	}

	public static void Register()
	{
		EventEngine.Register(IPlayerInteractEvent.class, new EventRouterFactory()
		{
			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PlayerInteract(output, scheduler, (IPlayerInteractEvent) subscriber);
			}
		});
	}
}
