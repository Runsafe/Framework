package no.runsafe.framework.internal.event.listener.inventory;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.inventory.IInventory;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryEvent;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryEvent;

public final class Inventory extends EventRouterBase<IInventory, InventoryEvent>
{
	private Inventory(IOutput output, IScheduler scheduler, IInventory handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(InventoryEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(InventoryEvent event)
	{
		handler.OnInventoryEvent(new RunsafeInventoryEvent(event));
		return true;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IInventory> getInterface()
			{
				return IInventory.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new Inventory(output, scheduler, (IInventory) subscriber);
			}
		};
	}
}
