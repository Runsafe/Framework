package no.runsafe.framework.event.listener.inventory;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.inventory.IInventoryPickupItem;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.inventory.RunsafeInventoryPickupItemEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryPickupItemEvent;

public class InventoryPickupItem extends EventRouterBase<IInventoryPickupItem, InventoryPickupItemEvent>
{
	protected InventoryPickupItem(IOutput output, IScheduler scheduler, IInventoryPickupItem handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(InventoryPickupItemEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(InventoryPickupItemEvent event)
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
