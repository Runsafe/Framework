package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.block.IBlockPlaceEvent;
import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.server.event.block.RunsafeBlockPlaceEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlace extends EventRouter<IBlockPlaceEvent, BlockPlaceEvent>
{
	public BlockPlace(IScheduler scheduler, IBlockPlaceEvent handler)
	{
		super(scheduler, handler);
	}

	@EventHandler
	public void OnEvent(BlockPlaceEvent event)
	{
		handler.OnBlockPlaceEvent(new RunsafeBlockPlaceEvent(event));
	}
}
