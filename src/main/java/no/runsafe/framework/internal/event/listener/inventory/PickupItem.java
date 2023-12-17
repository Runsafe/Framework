package no.runsafe.framework.internal.event.listener.inventory;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.inventory.IInventoryPickupItem;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryPickupItemEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryPickupItemEvent;

public final class PickupItem extends EventRouterBase<IInventoryPickupItem, InventoryPickupItemEvent>
{
	PickupItem(IConsole output, IScheduler scheduler, IInventoryPickupItem handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(InventoryPickupItemEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(InventoryPickupItemEvent event)
	{
		handler.OnInventoryPickupItemEvent(new RunsafeInventoryPickupItemEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IInventoryPickupItem.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PickupItem(output, scheduler, (IInventoryPickupItem) subscriber);
			}
		};
	}
}
