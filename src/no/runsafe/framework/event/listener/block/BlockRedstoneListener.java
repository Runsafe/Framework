package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.EventEngine;
import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.block.IBlockRedstoneEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.block.RunsafeBlockRedstoneEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;

@SuppressWarnings("deprecation")
@Deprecated
public class BlockRedstoneListener extends EventRouterBase<IBlockRedstoneEvent, BlockRedstoneEvent>
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

	@Override
	public boolean OnEvent(BlockRedstoneEvent event)
	{
		handler.OnBlockRedstoneEvent(new RunsafeBlockRedstoneEvent(event));
		return true;
	}

	public static void Register()
	{
		EventEngine.Register(IBlockRedstoneEvent.class, new EventRouterFactory()
		{
			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new BlockRedstoneListener(output, scheduler, (IBlockRedstoneEvent) subscriber);
			}
		});
	}
}
