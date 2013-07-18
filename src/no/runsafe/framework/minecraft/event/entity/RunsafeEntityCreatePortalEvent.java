package no.runsafe.framework.minecraft.event.entity;

import org.bukkit.event.entity.EntityCreatePortalEvent;

public class RunsafeEntityCreatePortalEvent extends RunsafeCancellableEntityEvent
{
	public RunsafeEntityCreatePortalEvent(EntityCreatePortalEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	private final EntityCreatePortalEvent event;
}
