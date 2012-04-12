package no.runsafe.framework.event.server.entity;

import no.runsafe.framework.entity.RunsafeEntity;
import no.runsafe.framework.event.server.CancellableEvent;
import org.bukkit.event.Cancellable;
import org.bukkit.event.entity.EntityDamageEvent;

public class RunsafeEntityDamageEvent extends RunsafeEntityEvent implements CancellableEvent
{
	public RunsafeEntityDamageEvent(EntityDamageEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public int getDamage()
	{
		return event.getDamage();
	}

	public void setDamage(int damage)
	{
		event.setDamage(damage);
	}

	public RunsafeEntity getEntity()
	{
		return new RunsafeEntity(event.getEntity());
	}

	@Override
	public boolean getCancelled()
	{
		return event.isCancelled();
	}

	@Override
	public void setCancelled(boolean cancel)
	{
		event.setCancelled(cancel);
	}

	private EntityDamageEvent event;
}
