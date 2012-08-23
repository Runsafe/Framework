package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.player.IPlayerLeftClickAirEvent;
import no.runsafe.framework.event.player.IPlayerLeftClickBlockEvent;
import no.runsafe.framework.event.player.IPlayerLeftClickEvent;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.player.RunsafePlayerClickEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerLeftClick extends EventRouter<IPlayerLeftClickEvent, PlayerInteractEvent>
{
	public PlayerLeftClick(IOutput output, IScheduler scheduler, IPlayerLeftClickEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(PlayerInteractEvent event)
	{
		super.AcceptEvent(event);
	}

	public boolean OnEvent(PlayerInteractEvent event)
	{
		if (!(handler instanceof IPlayerLeftClickAirEvent || handler instanceof IPlayerLeftClickBlockEvent))
			handler.OnPlayerLeftClick(new RunsafePlayerClickEvent(event));

		else if (handler instanceof IPlayerLeftClickAirEvent && event.getAction() == Action.LEFT_CLICK_AIR)
			handler.OnPlayerLeftClick(new RunsafePlayerClickEvent(event));

		else if (handler instanceof IPlayerLeftClickBlockEvent && event.getAction() == Action.LEFT_CLICK_BLOCK)
			handler.OnPlayerLeftClick(new RunsafePlayerClickEvent(event));

		return true;
	}
}
