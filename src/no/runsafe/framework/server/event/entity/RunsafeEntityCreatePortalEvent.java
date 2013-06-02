package no.runsafe.framework.server.event.entity;

import no.runsafe.framework.server.event.CancellableEvent;
import org.bukkit.event.entity.EntityCreatePortalEvent;

public class RunsafeEntityCreatePortalEvent extends RunsafeEntityEvent implements CancellableEvent
{
	public RunsafeEntityCreatePortalEvent(EntityCreatePortalEvent toWrap)
	{
		super(toWrap);
		this.event = toWrap;
	}

	@Override
	public boolean getCancelled()
	{
		return this.event.isCancelled();
	}

	@Override
	public void setCancelled(boolean cancel)
	{
		this.event.setCancelled(cancel);
	}

	final EntityCreatePortalEvent event;
}
