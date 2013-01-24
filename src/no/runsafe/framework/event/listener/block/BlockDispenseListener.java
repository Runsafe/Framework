package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.block.IBlockDispenseEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.block.RunsafeBlockDispenseEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;

@SuppressWarnings("deprecation")
@Deprecated
public class BlockDispenseListener extends EventRouterBase<IBlockDispenseEvent, BlockDispenseEvent>
{
	public BlockDispenseListener(IOutput output, IScheduler scheduler, IBlockDispenseEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(BlockDispenseEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(BlockDispenseEvent event)
	{
		handler.OnBlockDispenseEvent(new RunsafeBlockDispenseEvent(event));
		return true;
	}

	static class Factory implements EventRouterFactory
	{
		@Override
		public Class<? extends IRunsafeEvent> getInterface()
		{
			return IBlockDispenseEvent.class;
		}

		@Override
		public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
		{
			return new BlockDispenseListener(output, scheduler, (IBlockDispenseEvent) subscriber);
		}
	}
}
