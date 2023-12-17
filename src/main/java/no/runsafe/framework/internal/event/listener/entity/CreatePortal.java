package no.runsafe.framework.internal.event.listener.entity;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.entity.IEntityCreatePortalEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityCreatePortalEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityCreatePortalEvent;

public final class CreatePortal extends EventRouterBase<IEntityCreatePortalEvent, EntityCreatePortalEvent>
{
	CreatePortal(IConsole output, IScheduler scheduler, IEntityCreatePortalEvent handler)
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
	public boolean onEvent(EntityCreatePortalEvent event)
	{
		handler.OnEntityCreatePortal(new RunsafeEntityCreatePortalEvent(event));
		return false;
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
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new CreatePortal(output, scheduler, (IEntityCreatePortalEvent) subscriber);
			}
		};
	}
}

