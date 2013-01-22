package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.EventEngine;
import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.event.player.IPlayerRightClickSign;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.block.RunsafeSign;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.logging.Level;

public class PlayerRightClickSign extends EventRouterBase<IPlayerRightClickSign, PlayerInteractEvent>
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

	@Override
	public boolean OnEvent(PlayerInteractEvent event)
	{
		if (event.getAction() != Action.RIGHT_CLICK_BLOCK)
			return true;

		if (event.getClickedBlock() == null || !(event.getClickedBlock().getState() instanceof Sign))
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
				(RunsafeSign) ObjectWrapper.convert(event.getClickedBlock().getState())
			);
	}

	public static void Register()
	{
		EventEngine.Register(IPlayerRightClickSign.class, new EventRouterFactory()
		{
			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PlayerRightClickSign(output, scheduler, (IPlayerRightClickSign) subscriber);
			}
		});
	}

	private final IOutput console;
}
