package no.runsafe.framework.server.event.entity;

import org.bukkit.event.entity.EntityCreatePortalEvent;

public class RunsafeEntityCreatePortalEvent extends RunsafeEntityEvent
{
	public RunsafeEntityCreatePortalEvent(EntityCreatePortalEvent toWrap)
	{
		super(toWrap);
		this.event = toWrap;
	}

	EntityCreatePortalEvent event;
}
