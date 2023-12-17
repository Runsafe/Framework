package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.player.IPlayerLeftClickAirEvent;
import no.runsafe.framework.api.event.player.IPlayerLeftClickBlockEvent;
import no.runsafe.framework.api.event.player.IPlayerLeftClickEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public final class LeftClick extends EventRouterBase<IPlayerLeftClickEvent, PlayerInteractEvent>
{
	LeftClick(IConsole output, IScheduler scheduler, IPlayerLeftClickEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(PlayerInteractEvent event)
	{
		boolean accept = false;
		if (handler instanceof IPlayerLeftClickAirEvent && event.getAction() == Action.LEFT_CLICK_AIR)
			accept = true;

		if (handler instanceof IPlayerLeftClickBlockEvent && event.getAction() == Action.LEFT_CLICK_BLOCK)
			accept = true;

		if (!(handler instanceof IPlayerLeftClickAirEvent || handler instanceof IPlayerLeftClickBlockEvent))
			accept = true;

		if (accept)
			super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(PlayerInteractEvent event)
	{
		handler.OnPlayerLeftClick(new RunsafePlayerClickEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IPlayerLeftClickEvent.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new LeftClick(output, scheduler, (IPlayerLeftClickEvent) subscriber);
			}
		};
	}
}
