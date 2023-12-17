package no.runsafe.framework.internal.event.listener.entity;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.entity.IEntityTeleport;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityTeleportEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTeleportEvent;

public class TeleportEvent extends EventRouterBase<IEntityTeleport, EntityTeleportEvent>
{
	TeleportEvent(IConsole output, IScheduler scheduler, IEntityTeleport handler)
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
		return !handler.OnEntityTeleport(
			ObjectWrapper.convert(event.getEntity()),
			ObjectWrapper.convert(event.getFrom()),
			ObjectWrapper.convert(event.getTo())
		);
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IEntityTeleport.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new TeleportEvent(output, scheduler, (IEntityTeleport) subscriber);
			}
		};
	}
}
