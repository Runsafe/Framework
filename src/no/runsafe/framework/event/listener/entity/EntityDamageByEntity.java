package no.runsafe.framework.event.listener.entity;

import no.runsafe.framework.event.entity.IEntityDamageByEntityEvent;
import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.entity.RunsafeEntityDamageByEntityEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
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

	public boolean OnEvent(EntityDamageByEntityEvent entityDamageByEntityEvent)
	{
		handler.OnEntityDamageByEntity(new RunsafeEntityDamageByEntityEvent(entityDamageByEntityEvent));
		return true;
	}
}
