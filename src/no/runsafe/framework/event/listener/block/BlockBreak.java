package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.block.IBlockBreak;
import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak extends EventRouter<IBlockBreak, BlockBreakEvent>
{
	public BlockBreak(IOutput output, IScheduler scheduler, IBlockBreak handler)
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
}
