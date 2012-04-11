package no.runsafe.framework.entity.event;

import no.runsafe.framework.entity.event.IEntityDamageByEntityEvent;
import no.runsafe.framework.event.EventListener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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
		eventSubscriber.OnEntityDamageByEntity(entityDamageByEntityEvent);
	}
}
