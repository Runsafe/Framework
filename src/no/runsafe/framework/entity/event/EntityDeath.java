package no.runsafe.framework.entity.event;

import no.runsafe.framework.event.EventListener;
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
		eventSubscriber.OnEntityDeath(entityDeathEvent);
	}
}
