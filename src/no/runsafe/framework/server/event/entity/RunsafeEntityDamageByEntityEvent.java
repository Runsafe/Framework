package no.runsafe.framework.server.event.entity;

import no.runsafe.framework.server.entity.RunsafeEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class RunsafeEntityDamageByEntityEvent extends RunsafeEntityDamageEvent
{
	public RunsafeEntityDamageByEntityEvent(EntityDamageByEntityEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeEntity getDamageActor()
	{
		return new RunsafeEntity(event.getDamager());
	}

	private EntityDamageByEntityEvent event;
}
