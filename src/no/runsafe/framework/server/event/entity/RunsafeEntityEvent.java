package no.runsafe.framework.server.event.entity;

import no.runsafe.framework.server.entity.RunsafeEntity;
import no.runsafe.framework.server.event.RunsafeEvent;
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

	private final EntityEvent event;
}
