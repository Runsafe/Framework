package no.runsafe.framework.internal.event.listener.entity;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.entity.IItemSpawn;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.entity.RunsafeItemSpawnEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;

public final class ItemSpawn extends EventRouterBase<IItemSpawn, ItemSpawnEvent>
{
	ItemSpawn(IConsole output, IScheduler scheduler, IItemSpawn handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(ItemSpawnEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(ItemSpawnEvent event)
	{
		handler.OnItemSpawn(new RunsafeItemSpawnEvent(event));
		return true;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IItemSpawn.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new ItemSpawn(output, scheduler, (IItemSpawn) subscriber);
			}
		};
	}
}