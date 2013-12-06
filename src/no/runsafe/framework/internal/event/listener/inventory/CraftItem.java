package no.runsafe.framework.internal.event.listener.inventory;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IDebug;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.inventory.ICraftItem;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.inventory.RunsafeCraftItemEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public final class CraftItem extends EventRouterBase<ICraftItem, CraftItemEvent>
{
	CraftItem(IDebug output, IScheduler scheduler, ICraftItem handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(CraftItemEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(CraftItemEvent event)
	{
		handler.OnCraftItem(new RunsafeCraftItemEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends ICraftItem> getInterface()
			{
				return ICraftItem.class;
			}

			@Override
			public Listener getListener(IDebug output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new CraftItem(output, scheduler, (ICraftItem) subscriber);
			}
		};
	}
}