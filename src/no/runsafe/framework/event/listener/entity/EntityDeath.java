package no.runsafe.framework.event.listener.entity;

import no.runsafe.framework.event.EventListener;
import no.runsafe.framework.event.server.entity.RunsafeEntityDeathEvent;
import no.runsafe.framework.event.subscriber.entity.IEntityDeathEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeath extends EventListener<IEntityDeathEvent, EntityDeathEvent>
{
	public EntityDeath(IEntityDeathEvent iEntityDeathEvent)
	{
		super(iEntityDeathEvent);
	}

	@Override
	public void OnEvent(EntityDeathEvent entityDeathEvent)
	{
		eventSubscriber.OnEntityDeath(new RunsafeEntityDeathEvent(entityDeathEvent));
	}
}
