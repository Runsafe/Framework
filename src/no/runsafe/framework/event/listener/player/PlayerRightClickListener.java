package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.player.IPlayerRightClickAirEvent;
import no.runsafe.framework.event.player.IPlayerRightClickBlockEvent;
import no.runsafe.framework.event.player.IPlayerRightClickEvent;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.player.RunsafePlayerClickEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

@Deprecated
public class PlayerRightClickListener extends EventRouter<IPlayerRightClickEvent, PlayerInteractEvent>
{
	public PlayerRightClickListener(IOutput output, IScheduler scheduler, IPlayerRightClickEvent handler)
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
		if (!(handler instanceof IPlayerRightClickAirEvent || handler instanceof IPlayerRightClickBlockEvent))
			handler.OnPlayerRightClick(new RunsafePlayerClickEvent(event));

		else if (handler instanceof IPlayerRightClickAirEvent && event.getAction() == Action.RIGHT_CLICK_AIR)
			handler.OnPlayerRightClick(new RunsafePlayerClickEvent(event));

		else if (handler instanceof IPlayerRightClickBlockEvent && event.getAction() == Action.RIGHT_CLICK_BLOCK)
			handler.OnPlayerRightClick(new RunsafePlayerClickEvent(event));

		return true;
	}
}
