package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.player.IPlayerLoginEvent;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.player.RunsafePlayerLoginEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLogin extends EventRouter<IPlayerLoginEvent, PlayerLoginEvent>
{
	public PlayerLogin(IOutput output, IScheduler scheduler, IPlayerLoginEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(PlayerLoginEvent event)
	{
		super.AcceptEvent(event);
	}

	public boolean OnEvent(PlayerLoginEvent event)
	{
		handler.OnPlayerLogin(new RunsafePlayerLoginEvent(event));
		return true;
	}
}
