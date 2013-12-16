package no.runsafe.framework.internal.event.listener.inventory;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.inventory.IInventoryOpen;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

public final class Open extends EventRouterBase<IInventoryOpen, InventoryOpenEvent>
{
	Open(IConsole output, IScheduler scheduler, IInventoryOpen handler)
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
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new Open(output, scheduler, (IInventoryOpen) subscriber);
			}
		};
	}
}
