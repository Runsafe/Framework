package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.player.IPlayerRightClick;
import no.runsafe.framework.event.player.IPlayerRightClickAir;
import no.runsafe.framework.event.player.IPlayerRightClickBlock;
import no.runsafe.framework.event.player.IPlayerRightClickSign;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.block.RunsafeSign;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerRightClick extends EventRouter<IPlayerRightClick, PlayerInteractEvent>
{
	public PlayerRightClick(IOutput output, IScheduler scheduler, IPlayerRightClick handler)
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
		if (handler instanceof IPlayerRightClickAir && event.getAction() != Action.RIGHT_CLICK_AIR)
			return true;

		if (handler instanceof IPlayerRightClickBlock && event.getAction() != Action.RIGHT_CLICK_BLOCK)
			return true;

		return
			handler.OnPlayerRightClick(
				ObjectWrapper.convert(event.getPlayer()),
				ObjectWrapper.convert(event.getItem()),
				ObjectWrapper.convert(event.getClickedBlock())
			);
	}
}

