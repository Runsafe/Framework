package no.runsafe.framework.event.listener.inventory;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.inventory.IChestClosed;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class ChestClose extends EventRouterBase<IChestClosed, InventoryCloseEvent>
{
	protected ChestClose(IOutput output, IScheduler scheduler, IChestClosed handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(InventoryCloseEvent event)
	{
		if (event.getInventory().getHolder() instanceof Chest)
			super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(InventoryCloseEvent event)
	{
		handler.OnChestClosed(
			ObjectWrapper.convert(event.getPlayer()),
			ObjectWrapper.convert(event.getInventory())
		);
		return true;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IChestClosed> getInterface()
			{
				return IChestClosed.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new ChestClose(output, scheduler, (IChestClosed) subscriber);
			}
		};
	}
}
