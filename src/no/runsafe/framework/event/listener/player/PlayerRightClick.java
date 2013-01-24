package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.event.player.IPlayerRightClick;
import no.runsafe.framework.event.player.IPlayerRightClickAir;
import no.runsafe.framework.event.player.IPlayerRightClickBlock;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public final class PlayerRightClick extends EventRouterBase<IPlayerRightClick, PlayerInteractEvent>
{
	public PlayerRightClick(IOutput output, IScheduler scheduler, IPlayerRightClick handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(PlayerInteractEvent event)
	{
		if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK)
			return;

		if (handler instanceof IPlayerRightClickAir && event.getAction() != Action.RIGHT_CLICK_AIR)
			return;

		if (handler instanceof IPlayerRightClickBlock && event.getAction() != Action.RIGHT_CLICK_BLOCK)
			return;

		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(PlayerInteractEvent event)
	{
		return
			handler.OnPlayerRightClick(
				ObjectWrapper.convert(event.getPlayer()),
				ObjectWrapper.convert(event.getItem()),
				ObjectWrapper.convert(event.getClickedBlock())
			);
	}

	public final static class Factory implements EventRouterFactory
	{
		@Override
		public Class<? extends IRunsafeEvent> getInterface()
		{
			return IPlayerRightClick.class;
		}

		@Override
		public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
		{
			return new PlayerRightClick(output, scheduler, (IPlayerRightClick) subscriber);
		}
	}
}
