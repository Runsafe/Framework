package no.runsafe.framework.event.server.entity;

import no.runsafe.framework.entity.RunsafeEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class RunsafeEntityDamageByEntityEvent extends RunsafeEntityDamageEvent
{
	public RunsafeEntityDamageByEntityEvent(EntityDamageByEntityEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeEntity getDamager()
	{
		return new RunsafeEntity(event.getDamager());
	}

	private EntityDamageByEntityEvent event;
}
