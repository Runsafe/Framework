package no.runsafe.framework.server.event.entity;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.block.RunsafeBlock;
import org.bukkit.event.entity.EntityPortalEnterEvent;

public class RunsafeEntityPortalEnterEvent extends RunsafeEntityEvent
{
	public RunsafeEntityPortalEnterEvent(EntityPortalEnterEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeLocation getLocation()
	{
		return ObjectWrapper.convert(this.event.getLocation());
	}

	public RunsafeBlock getBlock()
	{
		return this.getLocation().getBlock();
	}

	private final EntityPortalEnterEvent event;
}
