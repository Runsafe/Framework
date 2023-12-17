package no.runsafe.framework.internal.event.listener.block;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.block.IBlockBreak;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public final class Break extends EventRouterBase<IBlockBreak, BlockBreakEvent>
{
	Break(IConsole output, IScheduler scheduler, IBlockBreak handler)
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
		return !handler.OnBlockBreak(
			ObjectWrapper.convert((OfflinePlayer) event.getPlayer()),
			ObjectWrapper.convert(event.getBlock())
		);
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IBlockBreak.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new Break(output, scheduler, (IBlockBreak) subscriber);
			}
		};
	}
}
