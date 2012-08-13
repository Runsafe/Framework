package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.block.IBlockBreakEvent;
import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.server.event.block.RunsafeBlockBreakEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak extends EventRouter<IBlockBreakEvent, BlockBreakEvent>
{
	public BlockBreak(IScheduler scheduler, IBlockBreakEvent handler)
	{
		super(scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(BlockBreakEvent event)
	{
		super.AcceptEvent(event);
	}

	public void OnEvent(BlockBreakEvent event)
	{
		handler.OnBlockBreakEvent(new RunsafeBlockBreakEvent(event));
	}
}
