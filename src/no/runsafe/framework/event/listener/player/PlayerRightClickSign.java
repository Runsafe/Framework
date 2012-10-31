package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.player.IPlayerRightClick;
import no.runsafe.framework.event.player.IPlayerRightClickSign;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.block.RunsafeSign;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerRightClickSign extends EventRouter<IPlayerRightClickSign, PlayerInteractEvent>
{
	public PlayerRightClickSign(IOutput output, IScheduler scheduler, IPlayerRightClickSign handler)
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
		if(event.getAction() != Action.RIGHT_CLICK_BLOCK)
			return true;

		if(event.getClickedBlock() == null || !(event.getClickedBlock().getState() instanceof Sign))
			return true;

		return
			handler.OnPlayerRightClickSign(
				ObjectWrapper.convert(event.getPlayer()),
				ObjectWrapper.convert(event.getItem()),
				(RunsafeSign)ObjectWrapper.convert(event.getClickedBlock().getState())
			);
	}
}
