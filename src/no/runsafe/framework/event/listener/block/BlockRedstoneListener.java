package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.block.IBlockRedstoneEvent;
import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.block.RunsafeBlockRedstoneEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockRedstoneEvent;

@SuppressWarnings("deprecation")
@Deprecated
public class BlockRedstoneListener extends EventRouter<IBlockRedstoneEvent, BlockRedstoneEvent>
{
	public BlockRedstoneListener(IOutput output, IScheduler scheduler, IBlockRedstoneEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(BlockRedstoneEvent event)
	{
		super.AcceptEvent(event);
	}

	public boolean OnEvent(BlockRedstoneEvent event)
	{
		handler.OnBlockRedstoneEvent(new RunsafeBlockRedstoneEvent(event));
		return true;
	}
}
