package no.runsafe.framework.internal.event.listener.entity;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.entity.IEntityPortalEnterEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityPortalEnterEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEnterEvent;

public final class PortalEnter extends EventRouterBase<IEntityPortalEnterEvent, EntityPortalEnterEvent>
{
	PortalEnter(IConsole output, IScheduler scheduler, IEntityPortalEnterEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(EntityPortalEnterEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(EntityPortalEnterEvent event)
	{
		handler.OnEntityPortalEnter(new RunsafeEntityPortalEnterEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IEntityPortalEnterEvent.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PortalEnter(output, scheduler, (IEntityPortalEnterEvent) subscriber);
			}
		};
	}
}
