package no.runsafe.framework.internal.event.listener.entity;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.entity.IEntityDamageEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public final class EntityDamage extends EventRouterBase<IEntityDamageEvent, EntityDamageEvent>
{
	EntityDamage(IDebug output, IScheduler scheduler, IEntityDamageEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(EntityDamageEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(EntityDamageEvent event)
	{
		handler.OnEntityDamage(new RunsafeEntityDamageEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IEntityDamageEvent.class;
			}

			@Override
			public Listener getListener(IDebug output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new EntityDamage(output, scheduler, (IEntityDamageEvent) subscriber);
			}
		};
	}
}
