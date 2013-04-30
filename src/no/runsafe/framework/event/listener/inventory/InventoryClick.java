package no.runsafe.framework.event.listener.inventory;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.inventory.IInventoryClick;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.inventory.RunsafeInventoryClickEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick extends EventRouterBase<IInventoryClick, InventoryClickEvent>
{
	protected InventoryClick(IOutput output, IScheduler scheduler, IInventoryClick handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(InventoryClickEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(InventoryClickEvent event)
	{
		handler.OnInventoryClickEvent(new RunsafeInventoryClickEvent(event));
		return true;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IInventoryClick> getInterface()
			{
				return IInventoryClick.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new InventoryClick(output, scheduler, (IInventoryClick) subscriber);
			}
		};
	}
}
