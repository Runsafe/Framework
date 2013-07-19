package no.runsafe.framework.internal.event.listener.entity;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.entity.IEntityShootBowEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityShootBowEvent;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public final class EntityShootBow extends EventRouterBase<IEntityShootBowEvent, EntityShootBowEvent>
{
	EntityShootBow(IOutput output, IScheduler scheduler, IEntityShootBowEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(EntityShootBowEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(EntityShootBowEvent event)
	{
		handler.OnEntityShootBowEvent(new RunsafeEntityShootBowEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IEntityShootBowEvent.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new EntityShootBow(output, scheduler, (IEntityShootBowEvent) subscriber);
			}
		};
	}
}
