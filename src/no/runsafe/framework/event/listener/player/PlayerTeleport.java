package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.player.IPlayerTeleportEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerTeleportEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerTeleport extends EventRouter<IPlayerTeleportEvent, PlayerTeleportEvent>
{
	public PlayerTeleport(IScheduler scheduler, IPlayerTeleportEvent handler)
	{
		super(scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(PlayerTeleportEvent event)
	{
		super.AcceptEvent(event);
	}

	public void OnEvent(PlayerTeleportEvent event)
	{
		handler.OnPlayerTeleport(new RunsafePlayerTeleportEvent(event));
	}
}
