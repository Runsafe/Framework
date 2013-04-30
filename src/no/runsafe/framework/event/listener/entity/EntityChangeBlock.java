package no.runsafe.framework.event.listener.entity;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.entity.IEntityChangeBlockEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.entity.RunsafeEntityChangeBlockEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public final class EntityChangeBlock extends EventRouterBase<IEntityChangeBlockEvent, EntityChangeBlockEvent>
{
	public EntityChangeBlock(IOutput output, IScheduler scheduler, IEntityChangeBlockEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(EntityChangeBlockEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(EntityChangeBlockEvent entityChangeBlockEvent)
	{
		handler.OnEntityChangeBlockEvent(new RunsafeEntityChangeBlockEvent(entityChangeBlockEvent));
		return true;
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
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new EntityChangeBlock(output, scheduler, (IEntityChangeBlockEvent) subscriber);
			}
		};
	}
}
