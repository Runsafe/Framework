package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.EventEngine;
import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.event.player.IPlayerMove;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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

	@Override
	public boolean OnEvent(PlayerMoveEvent event)
	{
		return handler.OnPlayerMove(ObjectWrapper.convert(event.getPlayer()), ObjectWrapper.convert(event.getFrom()), ObjectWrapper.convert(event.getTo()));
	}

	public static void Register()
	{
		EventEngine.Register(IPlayerMove.class, new EventRouterFactory()
		{
			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PlayerMove(output, scheduler, (IPlayerMove) subscriber);
			}
		});
	}
}
