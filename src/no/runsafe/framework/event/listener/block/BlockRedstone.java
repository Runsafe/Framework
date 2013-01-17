package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.EventEngine;
import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.block.IBlockRedstone;
import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;

public class BlockRedstone extends EventRouter<IBlockRedstone, BlockRedstoneEvent>
{
	public BlockRedstone(IOutput output, IScheduler scheduler, IBlockRedstone handler)
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
		int current = handler.OnBlockRedstone(event.getOldCurrent(), event.getNewCurrent());
		if (current >= 0)
			event.setNewCurrent(current);
		return true;
	}

	static
	{
		EventEngine.Register(IBlockRedstone.class, new EventRouterFactory()
		{
			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new BlockRedstone(output, scheduler, (IBlockRedstone) subscriber);
			}
		});
	}
}

