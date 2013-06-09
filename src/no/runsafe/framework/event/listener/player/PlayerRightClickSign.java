package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.event.player.IPlayerRightClickSign;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.block.RunsafeSign;
import no.runsafe.framework.timer.IScheduler;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public final class PlayerRightClickSign extends EventRouterBase<IPlayerRightClickSign, PlayerInteractEvent>
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

	@Override
	public boolean OnEvent(PlayerInteractEvent event)
	{
		return (event.getAction() != Action.RIGHT_CLICK_BLOCK)
			|| event.getClickedBlock() == null
			|| !(event.getClickedBlock().getState() instanceof Sign)
			|| handler.OnPlayerRightClickSign(
					ObjectWrapper.convert(event.getPlayer()),
					ObjectWrapper.convert(event.getItem()),
					(RunsafeSign)ObjectWrapper.convert(event.getClickedBlock().getState())
				);

	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IPlayerRightClickSign.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PlayerRightClickSign(output, scheduler, (IPlayerRightClickSign) subscriber);
			}
		};
	}
}
