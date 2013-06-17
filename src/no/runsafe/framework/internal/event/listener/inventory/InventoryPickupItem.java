package no.runsafe.framework.internal.event.listener.inventory;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.inventory.IInventoryPickupItem;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryPickupItemEvent;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryPickupItemEvent;

public final class InventoryPickupItem extends EventRouterBase<IInventoryPickupItem, InventoryPickupItemEvent>
{
	protected InventoryPickupItem(IOutput output, IScheduler scheduler, IInventoryPickupItem handler)
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
		this.handler.OnInventoryPickupItemEvent(new RunsafeInventoryPickupItemEvent(event));
		return true;
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
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new InventoryPickupItem(output, scheduler, (IInventoryPickupItem) subscriber);
			}
		};
	}
}
