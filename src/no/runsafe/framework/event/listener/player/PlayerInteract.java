package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.player.IPlayerInteractEvent;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.player.RunsafePlayerInteractEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract extends EventRouter<IPlayerInteractEvent, PlayerInteractEvent>
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

	@EventHandler
	public boolean OnEvent(PlayerInteractEvent event)
	{
		handler.OnPlayerInteractEvent(new RunsafePlayerInteractEvent(event));
		return true;
	}
}
