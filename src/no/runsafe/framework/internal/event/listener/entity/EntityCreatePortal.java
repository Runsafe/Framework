package no.runsafe.framework.internal.event.listener.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.entity.IEntityCreatePortalEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityCreatePortalEvent;
import no.runsafe.framework.api.IScheduler;
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
	public void acceptEvent(EntityCreatePortalEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(EntityCreatePortalEvent entityDeathEvent)
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

