package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.player.IPlayerInteractEntityEvent;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.player.RunsafePlayerInteractEntityEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerInteractEntity extends EventRouter<IPlayerInteractEntityEvent, PlayerInteractEntityEvent>
{
	public PlayerInteractEntity(IOutput output, IScheduler scheduler, IPlayerInteractEntityEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(PlayerInteractEntityEvent event)
	{
		super.AcceptEvent(event);
	}

	public boolean OnEvent(PlayerInteractEntityEvent event)
	{
		handler.OnPlayerInteractEntityEvent(new RunsafePlayerInteractEntityEvent(event));
		return true;
	}
}
