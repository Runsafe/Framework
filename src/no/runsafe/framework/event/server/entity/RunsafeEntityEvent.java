package no.runsafe.framework.event.server.entity;

import no.runsafe.framework.entity.RunsafeEntity;
import no.runsafe.framework.event.server.RunsafeEvent;
import org.bukkit.event.entity.EntityEvent;

public class RunsafeEntityEvent extends RunsafeEvent
{
	public RunsafeEntityEvent(EntityEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeEntity getEntity()
	{
		return new RunsafeEntity(event.getEntity());
	}

	private EntityEvent event;
}
