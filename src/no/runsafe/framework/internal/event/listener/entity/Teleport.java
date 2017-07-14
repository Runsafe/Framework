package no.runsafe.framework.internal.event.listener.entity;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.entity.IEntityTeleportEvent;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityTeleportEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;

public class Teleport extends EventRouterBase<IEntityTeleportEvent, EntityTeleportEvent>
{
	Teleport(IConsole output, IScheduler scheduler, IEntityTeleportEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(EntityTeleportEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(EntityTeleportEvent event)
	{
		handler.OnEntityTeleport(new RunsafeEntityTeleportEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IEntityTeleportEvent.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new Teleport(output, scheduler, (IEntityTeleportEvent) subscriber);
			}
		};
	}
}
