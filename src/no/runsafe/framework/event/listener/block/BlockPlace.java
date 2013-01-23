package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.EventEngine;
import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.block.IBlockPlace;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace extends EventRouterBase<IBlockPlace, BlockPlaceEvent>
{
	public BlockPlace(IOutput output, IScheduler scheduler, IBlockPlace handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(BlockPlaceEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(BlockPlaceEvent event)
	{
		return handler.OnBlockPlace(
			ObjectWrapper.convert(event.getPlayer()),
			ObjectWrapper.convert(event.getBlock())
		);
	}

	static class Factory implements EventRouterFactory
	{
		@Override
		public Class<? extends IRunsafeEvent> getInterface()
		{
			return IBlockPlace.class;
		}

		@Override
		public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
		{
			return new BlockPlace(output, scheduler, (IBlockPlace) subscriber);
		}
	}
}

