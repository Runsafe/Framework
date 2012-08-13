package no.runsafe.framework.event.listener.entity;

import no.runsafe.framework.event.entity.IEntityDeathEvent;
import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.server.event.entity.RunsafeEntityDeathEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeath extends EventRouter<IEntityDeathEvent, EntityDeathEvent>
{
	public EntityDeath(IScheduler scheduler, IEntityDeathEvent handler)
	{
		super(scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(EntityDeathEvent event)
	{
		super.AcceptEvent(event);
	}

	public void OnEvent(EntityDeathEvent entityDeathEvent)
	{
		handler.OnEntityDeath(new RunsafeEntityDeathEvent(entityDeathEvent));
	}
}
