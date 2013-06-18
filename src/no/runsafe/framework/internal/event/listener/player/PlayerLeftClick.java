package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.event.player.IPlayerLeftClickAirEvent;
import no.runsafe.framework.api.event.player.IPlayerLeftClickBlockEvent;
import no.runsafe.framework.api.event.player.IPlayerLeftClickEvent;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerClickEvent;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public final class PlayerLeftClick extends EventRouterBase<IPlayerLeftClickEvent, PlayerInteractEvent>
{
	private PlayerLeftClick(IOutput output, IScheduler scheduler, IPlayerLeftClickEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(PlayerInteractEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(PlayerInteractEvent event)
	{
		if (!(handler instanceof IPlayerLeftClickAirEvent || handler instanceof IPlayerLeftClickBlockEvent))
			handler.OnPlayerLeftClick(new RunsafePlayerClickEvent(event));

		else if (handler instanceof IPlayerLeftClickAirEvent && event.getAction() == Action.LEFT_CLICK_AIR)
			handler.OnPlayerLeftClick(new RunsafePlayerClickEvent(event));

		else if (handler instanceof IPlayerLeftClickBlockEvent && event.getAction() == Action.LEFT_CLICK_BLOCK)
			handler.OnPlayerLeftClick(new RunsafePlayerClickEvent(event));

		return true;
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
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PlayerLeftClick(output, scheduler, (IPlayerLeftClickEvent) subscriber);
			}
		};
	}
}
