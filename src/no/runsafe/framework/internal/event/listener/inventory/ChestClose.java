package no.runsafe.framework.internal.event.listener.inventory;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.inventory.IChestClosed;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public final class ChestClose extends EventRouterBase<IChestClosed, InventoryCloseEvent>
{
	protected ChestClose(IOutput output, IScheduler scheduler, IChestClosed handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(InventoryCloseEvent event)
	{
		if (event.getInventory().getHolder() instanceof Chest)
			super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(InventoryCloseEvent event)
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
