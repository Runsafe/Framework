package no.runsafe.framework.internal.event.listener.inventory;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.inventory.IInventoryOpen;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

public final class InventoryOpen extends EventRouterBase<IInventoryOpen, InventoryOpenEvent>
{
	InventoryOpen(IOutput output, IScheduler scheduler, IInventoryOpen handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(InventoryOpenEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(InventoryOpenEvent event)
	{
		return !handler.OnInventoryOpen(
			ObjectWrapper.convert(event.getPlayer()),
			ObjectWrapper.convert(event.getInventory())
		);
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IInventoryOpen> getInterface()
			{
				return IInventoryOpen.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new InventoryOpen(output, scheduler, (IInventoryOpen) subscriber);
			}
		};
	}
}
