package no.runsafe.framework.internal.event.listener.entity;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.entity.IItemDespawnEvent;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.entity.RunsafeItemDespawnEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemDespawnEvent;

public final class ItemDespawn extends EventRouterBase<IItemDespawnEvent, ItemDespawnEvent>
{
	ItemDespawn(IConsole output, IScheduler scheduler, IItemDespawnEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(ItemDespawnEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(ItemDespawnEvent event)
	{
		return !handler.OnItemDespawn(new RunsafeItemDespawnEvent(event));
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IItemDespawnEvent.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new ItemDespawn(output, scheduler, (IItemDespawnEvent) subscriber);
			}
		};
	}
}
