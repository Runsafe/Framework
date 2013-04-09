package no.runsafe.framework.event.listener.block;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.block.IChestBreak;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public final class ChestBreak extends EventRouterBase<IChestBreak, BlockBreakEvent>
{
	protected ChestBreak(IOutput output, IScheduler scheduler, IChestBreak handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(BlockBreakEvent event)
	{
		if (event.getBlock() instanceof Chest)
			super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(BlockBreakEvent event)
	{
		return handler.OnChestBreak(
			ObjectWrapper.convert(event.getPlayer()),
			ObjectWrapper.convert((Chest) event.getBlock())
		);
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IChestBreak.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new ChestBreak(output, scheduler, (IChestBreak) subscriber);
			}
		};
	}
}
