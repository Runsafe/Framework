package no.runsafe.framework.event.listener.entity;

import no.runsafe.framework.event.EventEngine;
import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.entity.IEntityDamageByEntityEvent;
import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.entity.RunsafeEntityDamageByEntityEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntity extends EventRouter<IEntityDamageByEntityEvent, EntityDamageByEntityEvent>
{
	public EntityDamageByEntity(IOutput output, IScheduler scheduler, IEntityDamageByEntityEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(EntityDamageByEntityEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(EntityDamageByEntityEvent entityDamageByEntityEvent)
	{
		handler.OnEntityDamageByEntity(new RunsafeEntityDamageByEntityEvent(entityDamageByEntityEvent));
		return true;
	}

	public static void Register()
	{
		EventEngine.Register(IEntityDamageByEntityEvent.class, new EventRouterFactory()
		{
			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new EntityDamageByEntity(output, scheduler, (IEntityDamageByEntityEvent) subscriber);
			}
		});
	}
}
