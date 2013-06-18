package no.runsafe.framework.internal.event.listener.inventory;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.inventory.IInventoryClick;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryClickEvent;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public final class InventoryClick extends EventRouterBase<IInventoryClick, InventoryClickEvent>
{
	private InventoryClick(IOutput output, IScheduler scheduler, IInventoryClick handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(InventoryClickEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(InventoryClickEvent event)
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
