package no.runsafe.framework.internal.event.listener.inventory;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IDebug;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.inventory.IInventoryMoveItem;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryMoveItemEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;

public final class InventoryMoveItem extends EventRouterBase<IInventoryMoveItem, InventoryMoveItemEvent>
{
	InventoryMoveItem(IDebug output, IScheduler scheduler, IInventoryMoveItem handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(InventoryMoveItemEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(InventoryMoveItemEvent event)
	{
		handler.OnInventoryMoveItemEvent(new RunsafeInventoryMoveItemEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IInventoryMoveItem> getInterface()
			{
				return IInventoryMoveItem.class;
			}

			@Override
			public Listener getListener(IDebug output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new InventoryMoveItem(output, scheduler, (IInventoryMoveItem) subscriber);
			}
		};
	}
}
