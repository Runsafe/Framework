package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.player.IPlayerQuitEvent;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.player.RunsafePlayerQuitEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit extends EventRouter<IPlayerQuitEvent, PlayerQuitEvent>
{
	public PlayerQuit(IOutput output, IScheduler scheduler, IPlayerQuitEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(PlayerQuitEvent event)
	{
		super.AcceptEvent(event);
	}

	@EventHandler
	public boolean OnEvent(PlayerQuitEvent event)
	{
		handler.OnPlayerQuit(new RunsafePlayerQuitEvent(event));
		return true;
	}
}
