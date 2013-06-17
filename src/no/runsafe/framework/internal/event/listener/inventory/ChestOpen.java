package no.runsafe.framework.internal.event.listener.inventory;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.inventory.IChestOpen;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

public final class ChestOpen extends EventRouterBase<IChestOpen, InventoryOpenEvent>
{
	protected ChestOpen(IOutput output, IScheduler scheduler, IChestOpen handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(InventoryOpenEvent event)
	{
		if (event.getInventory().getHolder() instanceof Chest)
			super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(InventoryOpenEvent event)
	{
		return handler.OnChestOpen(
			ObjectWrapper.convert(event.getPlayer()),
			ObjectWrapper.convert(event.getInventory())
		);
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IChestOpen> getInterface()
			{
				return IChestOpen.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new ChestOpen(output, scheduler, (IChestOpen) subscriber);
			}
		};
	}
}
