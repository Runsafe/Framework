package no.runsafe.framework.event.listener.entity;

import no.runsafe.framework.event.EventListener;
import no.runsafe.framework.event.server.entity.RunsafeEntityDamageByEntityEvent;
import no.runsafe.framework.event.subscriber.entity.IEntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntity extends EventListener<IEntityDamageByEntityEvent, EntityDamageByEntityEvent>
{
	public EntityDamageByEntity(IEntityDamageByEntityEvent iEntityDamageByEntityEvent)
	{
		super(iEntityDamageByEntityEvent);
	}

	@Override
	public void OnEvent(EntityDamageByEntityEvent entityDamageByEntityEvent)
	{
		eventSubscriber.OnEntityDamageByEntity(new RunsafeEntityDamageByEntityEvent(entityDamageByEntityEvent));
	}
}
