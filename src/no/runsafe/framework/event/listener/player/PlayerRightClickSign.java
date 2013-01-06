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

import java.util.logging.Level;

public class PlayerRightClickSign extends EventRouter<IPlayerRightClickSign, PlayerInteractEvent>
{
	public PlayerRightClickSign(IOutput output, IScheduler scheduler, IPlayerRightClickSign handler)
	{
		super(output, scheduler, handler);
		console = output;
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
		{
			console.outputDebugToConsole(String.format(
				"%s right clicked something that was not a sign.",
				event.getPlayer().getName()
			), Level.FINER);
			return true;
		}
		console.outputDebugToConsole(String.format(
			"%s right clicked a sign.",
			event.getPlayer().getName()
		), Level.FINE);
		return
			handler.OnPlayerRightClickSign(
				ObjectWrapper.convert(event.getPlayer()),
				ObjectWrapper.convert(event.getItem()),
				(RunsafeSign)ObjectWrapper.convert(event.getClickedBlock().getState())
			);
	}

	private final IOutput console;
}
