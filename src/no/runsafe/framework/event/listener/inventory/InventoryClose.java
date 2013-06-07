package no.runsafe.framework.event.listener.inventory;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.inventory.IInventoryClosed;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.inventory.RunsafeInventoryCloseEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryClose extends EventRouterBase<IInventoryClosed, InventoryCloseEvent>
{
	protected InventoryClose(IOutput output, IScheduler scheduler, IInventoryClosed handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(InventoryCloseEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(InventoryCloseEvent event)
	{
		handler.OnInventoryClosed(new RunsafeInventoryCloseEvent(event));
		return true;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IInventoryClosed> getInterface()
			{
				return IInventoryClosed.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new InventoryClose(output, scheduler, (IInventoryClosed) subscriber);
			}
		};
	}
}
