package no.runsafe.framework.internal.event.listener.entity;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.entity.IEntityToggleGlideEvent;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityToggleGlideEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

public class EntityToggleGlide extends EventRouterBase<IEntityToggleGlideEvent, EntityToggleGlideEvent>
{
	EntityToggleGlide(IConsole output, IScheduler scheduler, IEntityToggleGlideEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(EntityToggleGlideEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(EntityToggleGlideEvent event)
	{
		return !handler.OnEntityGlide(new RunsafeEntityToggleGlideEvent(event));
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IEntityToggleGlideEvent.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new EntityToggleGlide(output, scheduler, (IEntityToggleGlideEvent) subscriber);
			}
		};
	}
}
