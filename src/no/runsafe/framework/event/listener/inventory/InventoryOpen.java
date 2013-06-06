package no.runsafe.framework.event.listener.inventory;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.inventory.IInventoryOpen;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.player.RunsafePlayer;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class InventoryOpen extends EventRouterBase<IInventoryOpen, InventoryOpenEvent>
{
	protected InventoryOpen(IOutput output, IScheduler scheduler, IInventoryOpen handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(InventoryOpenEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(InventoryOpenEvent event)
	{
		return handler.OnInventoryOpen(
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
