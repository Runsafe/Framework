package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.EventEngine;
import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.block.IBlockBreakEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.block.RunsafeBlockBreakEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

@SuppressWarnings("deprecation")
@Deprecated
public class BlockBreakListener extends EventRouterBase<IBlockBreakEvent, BlockBreakEvent>
{
	public BlockBreakListener(IOutput output, IScheduler scheduler, IBlockBreakEvent handler)
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
		handler.OnBlockBreakEvent(new RunsafeBlockBreakEvent(event));
		return true;
	}

	public static void Register()
	{
		EventEngine.Register(IBlockBreakEvent.class, new EventRouterFactory()
		{
			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new BlockBreakListener(output, scheduler, (IBlockBreakEvent) subscriber);
			}
		});
	}
}
