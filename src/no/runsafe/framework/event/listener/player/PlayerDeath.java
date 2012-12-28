package no.runsafe.framework.event.listener.player;

import com.sun.corba.se.impl.transport.EventHandlerBase;
import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.player.IPlayerDeathEvent;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.player.RunsafePlayerDeathEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath extends EventRouter<IPlayerDeathEvent, PlayerDeathEvent>
{
	public PlayerDeath(IOutput output, IScheduler scheduler, IPlayerDeathEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(PlayerDeathEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(PlayerDeathEvent event)
	{
		handler.OnPlayerDeathEvent(new RunsafePlayerDeathEvent(event));
		return true;
	}
}
