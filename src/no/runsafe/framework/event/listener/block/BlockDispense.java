package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.EventEngine;
import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.block.IBlockDispense;
import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;

public class BlockDispense extends EventRouter<IBlockDispense, BlockDispenseEvent>
{
	public BlockDispense(IOutput output, IScheduler scheduler, IBlockDispense handler)
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
		return handler.OnBlockDispense(
			ObjectWrapper.convert(event.getBlock()),
			ObjectWrapper.convert(event.getItem())
		);
	}


	public static void Register()
	{
		EventEngine.Register(IBlockDispense.class, new EventRouterFactory()
		{
			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new BlockDispense(output, scheduler, (IBlockDispense) subscriber);
			}
		});
	}
}

