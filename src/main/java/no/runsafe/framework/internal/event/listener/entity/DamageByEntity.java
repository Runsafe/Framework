package no.runsafe.framework.internal.event.listener.entity;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.entity.IEntityDamageByEntityEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageByEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public final class DamageByEntity extends EventRouterBase<IEntityDamageByEntityEvent, EntityDamageByEntityEvent>
{
	DamageByEntity(IConsole output, IScheduler scheduler, IEntityDamageByEntityEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(EntityDamageByEntityEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(EntityDamageByEntityEvent event)
	{
		handler.OnEntityDamageByEntity(new RunsafeEntityDamageByEntityEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IEntityDamageByEntityEvent.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new DamageByEntity(output, scheduler, (IEntityDamageByEntityEvent) subscriber);
			}
		};
	}
}
