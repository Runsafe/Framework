package no.runsafe.framework.internal.event.listener.block;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.block.IBlockRedstone;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.block.RunsafeBlockRedstoneEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockRedstoneEvent;

public final class Redstone extends EventRouterBase<IBlockRedstone, BlockRedstoneEvent>
{
	Redstone(IConsole output, IScheduler scheduler, IBlockRedstone handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(BlockRedstoneEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(BlockRedstoneEvent event)
	{
		handler.OnBlockRedstoneEvent(new RunsafeBlockRedstoneEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IBlockRedstone.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new Redstone(output, scheduler, (IBlockRedstone) subscriber);
			}
		};
	}
}

