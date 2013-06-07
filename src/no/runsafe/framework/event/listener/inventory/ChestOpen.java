package no.runsafe.framework.event.listener.inventory;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.inventory.IChestOpen;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.block.Chest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

public class ChestOpen extends EventRouterBase<IChestOpen, InventoryOpenEvent>
{
	protected ChestOpen(IOutput output, IScheduler scheduler, IChestOpen handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(InventoryOpenEvent event)
	{
		if (event.getInventory().getHolder() instanceof Chest)
			super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(InventoryOpenEvent event)
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
