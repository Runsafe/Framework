package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.player.IPlayerRightClick;
import no.runsafe.framework.api.event.player.IPlayerRightClickAir;
import no.runsafe.framework.api.event.player.IPlayerRightClickBlock;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public final class RightClick extends EventRouterBase<IPlayerRightClick, PlayerInteractEvent>
{
	RightClick(IConsole output, IScheduler scheduler, IPlayerRightClick handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(PlayerInteractEvent event)
	{
		if (!(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK))
			return;

		if (handler instanceof IPlayerRightClickAir && event.getAction() != Action.RIGHT_CLICK_AIR)
			return;

		if (handler instanceof IPlayerRightClickBlock && event.getAction() != Action.RIGHT_CLICK_BLOCK)
			return;

		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(PlayerInteractEvent event)
	{
		return
			!handler.OnPlayerRightClick(
				ObjectWrapper.convert((OfflinePlayer) event.getPlayer()),
				ObjectWrapper.convert(event.getItem()),
				ObjectWrapper.convert(event.getClickedBlock())
			);
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IPlayerRightClick.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new RightClick(output, scheduler, (IPlayerRightClick) subscriber);
			}
		};
	}
}
