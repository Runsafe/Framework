package no.runsafe.framework.internal.event.listener.inventory;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.inventory.IPrepareCraftItem;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.inventory.RunsafePrepareItemCraftEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;

public final class PrepareCraftItem extends EventRouterBase<IPrepareCraftItem, PrepareItemCraftEvent>
{
	PrepareCraftItem(IConsole output, IScheduler scheduler, IPrepareCraftItem handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(PrepareItemCraftEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(PrepareItemCraftEvent event)
	{
		handler.OnPrepareCraftItem(new RunsafePrepareItemCraftEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IPrepareCraftItem> getInterface()
			{
				return IPrepareCraftItem.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PrepareCraftItem(output, scheduler, (IPrepareCraftItem) subscriber);
			}
		};
	}
}