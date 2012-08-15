package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.block.IBlockRedstoneEvent;
import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.server.event.block.RunsafeBlockRedstoneEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockRedstoneEvent;

public class BlockRedstone extends EventRouter<IBlockRedstoneEvent, BlockRedstoneEvent>
{
	public BlockRedstone(IScheduler scheduler, IBlockRedstoneEvent handler)
	{
		super(scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(BlockRedstoneEvent event)
	{
		super.AcceptEvent(event);
	}

	public void OnEvent(BlockRedstoneEvent event)
	{
		handler.OnBlockRedstoneEvent(new RunsafeBlockRedstoneEvent(event));
	}
}
