package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.block.IBlockBreak;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public final class BlockBreak extends EventRouterBase<IBlockBreak, BlockBreakEvent>
{
	protected BlockBreak(IOutput output, IScheduler scheduler, IBlockBreak handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(BlockBreakEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(BlockBreakEvent event)
	{
		return handler.OnBlockBreak(
			ObjectWrapper.convert(event.getPlayer()),
			ObjectWrapper.convert(event.getBlock())
		);
	}

	public final class Factory implements EventRouterFactory
	{
		@Override
		public Class<? extends IRunsafeEvent> getInterface()
		{
			return IBlockBreak.class;
		}

		@Override
		public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
		{
			return new BlockBreak(output, scheduler, (IBlockBreak) subscriber);
		}
	}
}
