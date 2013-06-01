package no.runsafe.framework.event.listener.entity;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.entity.IEntityCreatePortalEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.entity.RunsafeEntityCreatePortalEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCreatePortalEvent;

public final class EntityCreatePortal extends EventRouterBase<IEntityCreatePortalEvent, EntityCreatePortalEvent>
{
	public EntityCreatePortal(IOutput output, IScheduler scheduler, IEntityCreatePortalEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(EntityCreatePortalEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(EntityCreatePortalEvent entityDeathEvent)
	{
		handler.OnEntityCreatePortal(new RunsafeEntityCreatePortalEvent(entityDeathEvent));
		return true;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IEntityCreatePortalEvent.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new EntityCreatePortal(output, scheduler, (IEntityCreatePortalEvent) subscriber);
			}
		};
	}
}

