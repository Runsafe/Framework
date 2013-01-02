package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.player.IPlayerMove;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove extends EventRouter<IPlayerMove, PlayerMoveEvent>
{
	public PlayerMove(IOutput output, IScheduler scheduler, IPlayerMove handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(PlayerMoveEvent event)
	{
		super.AcceptEvent(event);
	}

	public boolean OnEvent(PlayerMoveEvent event)
	{
		return handler.OnPlayerMove(ObjectWrapper.convert(event.getPlayer()), ObjectWrapper.convert(event.getFrom()), ObjectWrapper.convert(event.getTo()));
	}
}
