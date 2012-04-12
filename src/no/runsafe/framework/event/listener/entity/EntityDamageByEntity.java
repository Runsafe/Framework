package no.runsafe.framework.event.listener.entity;

import no.runsafe.framework.event.server.entity.RunsafeEntityDamageByEntityEvent;
import no.runsafe.framework.event.subscriber.entity.IEntityDamageByEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntity implements Listener
{
	public EntityDamageByEntity(IEntityDamageByEntityEvent subscriber)
	{
		eventSubscriber = subscriber;
	}

	@EventHandler
	public void OnEvent(EntityDamageByEntityEvent entityDamageByEntityEvent)
	{
		eventSubscriber.OnEntityDamageByEntity(new RunsafeEntityDamageByEntityEvent(entityDamageByEntityEvent));
	}

	private IEntityDamageByEntityEvent eventSubscriber;
}
