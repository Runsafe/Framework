package no.runsafe.framework.internal.event.listener.block;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.block.IBlockBreakEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.block.RunsafeBlockBreakEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public final class BreakListener extends EventRouterBase<IBlockBreakEvent, BlockBreakEvent>
{
	BreakListener(IConsole output, IScheduler scheduler, IBlockBreakEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(BlockBreakEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(BlockBreakEvent event)
	{
		handler.OnBlockBreakEvent(new RunsafeBlockBreakEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IBlockBreakEvent.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new BreakListener(output, scheduler, (IBlockBreakEvent) subscriber);
			}
		};
	}
}
