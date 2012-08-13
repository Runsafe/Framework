package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.player.IPlayerChangedWorldEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerChangedWorldEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class PlayerChangedWorld extends EventRouter<IPlayerChangedWorldEvent, PlayerChangedWorldEvent>
{
	public PlayerChangedWorld(IScheduler scheduler, IPlayerChangedWorldEvent handler)
	{
		super(scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(PlayerChangedWorldEvent event)
	{
		super.AcceptEvent(event);
	}

	public void OnEvent(PlayerChangedWorldEvent event)
	{
		handler.OnPlayerChangedWorld(new RunsafePlayerChangedWorldEvent(event));
	}
}
