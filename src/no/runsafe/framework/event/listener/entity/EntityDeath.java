package no.runsafe.framework.event.listener.entity;

import no.runsafe.framework.server.event.entity.RunsafeEntityDeathEvent;
import no.runsafe.framework.event.entity.IEntityDeathEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeath implements Listener
{
	public EntityDeath(IEntityDeathEvent subscriber)
	{
		eventSubscriber = subscriber;
	}

	@EventHandler
	public void OnEvent(EntityDeathEvent entityDeathEvent)
	{
		eventSubscriber.OnEntityDeath(new RunsafeEntityDeathEvent(entityDeathEvent));
	}

	private final IEntityDeathEvent eventSubscriber;
}
