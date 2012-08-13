package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.block.IBlockDispenseEvent;
import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.server.event.block.RunsafeBlockDispenseEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockDispenseEvent;

public class BlockDispense extends EventRouter<IBlockDispenseEvent, BlockDispenseEvent>
{
	public BlockDispense(IScheduler scheduler, IBlockDispenseEvent handler)
	{
		super(scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(BlockDispenseEvent event)
	{
		super.AcceptEvent(event);
	}

	public void OnEvent(BlockDispenseEvent event)
	{
		handler.OnBlockDispenseEvent(new RunsafeBlockDispenseEvent(event));
	}
}
