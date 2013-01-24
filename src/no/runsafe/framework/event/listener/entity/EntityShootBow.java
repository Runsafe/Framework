package no.runsafe.framework.event.listener.entity;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.entity.IEntityShootBowEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.entity.RunsafeEntityShootBowEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public final class EntityShootBow extends EventRouterBase<IEntityShootBowEvent, EntityShootBowEvent>
{
	public EntityShootBow(IOutput output, IScheduler scheduler, IEntityShootBowEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(EntityShootBowEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(EntityShootBowEvent event)
	{
		handler.OnEntityShootBowEvent(new RunsafeEntityShootBowEvent(event));
		return true;
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
