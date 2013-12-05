package no.runsafe.framework.internal.event.listener.entity;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IDebug;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.entity.IEntityChangeBlockEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityChangeBlockEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public final class EntityChangeBlock extends EventRouterBase<IEntityChangeBlockEvent, EntityChangeBlockEvent>
{
	EntityChangeBlock(IDebug output, IScheduler scheduler, IEntityChangeBlockEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(EntityChangeBlockEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(EntityChangeBlockEvent event)
	{
		handler.OnEntityChangeBlockEvent(new RunsafeEntityChangeBlockEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IEntityChangeBlockEvent.class;
			}

			@Override
			public Listener getListener(IDebug output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new EntityChangeBlock(output, scheduler, (IEntityChangeBlockEvent) subscriber);
			}
		};
	}
}
