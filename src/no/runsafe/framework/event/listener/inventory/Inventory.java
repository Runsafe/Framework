package no.runsafe.framework.event.listener.inventory;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.inventory.IInventory;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.inventory.RunsafeInventoryEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryEvent;

public class Inventory extends EventRouterBase<IInventory, InventoryEvent>
{
	protected Inventory(IOutput output, IScheduler scheduler, IInventory handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(InventoryEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(InventoryEvent event)
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
