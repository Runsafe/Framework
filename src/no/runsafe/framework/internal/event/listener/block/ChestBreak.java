package no.runsafe.framework.internal.event.listener.block;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.block.IChestBreak;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public final class ChestBreak extends EventRouterBase<IChestBreak, BlockBreakEvent>
{
	ChestBreak(IOutput output, IScheduler scheduler, IChestBreak handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(BlockBreakEvent event)
	{
		if (event.getBlock() instanceof Chest)
			super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(BlockBreakEvent event)
	{
		return handler.OnChestBreak(
			ObjectWrapper.convert((OfflinePlayer) event.getPlayer()),
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
