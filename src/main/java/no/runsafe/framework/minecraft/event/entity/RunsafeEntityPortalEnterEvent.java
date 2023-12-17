package no.runsafe.framework.minecraft.event.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.entity.EntityPortalEnterEvent;

public class RunsafeEntityPortalEnterEvent extends RunsafeEntityEvent
{
	public RunsafeEntityPortalEnterEvent(EntityPortalEnterEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public ILocation getLocation()
	{
		return ObjectWrapper.convert(event.getLocation());
	}

	public IBlock getBlock()
	{
		return getLocation().getBlock();
	}

	private final EntityPortalEnterEvent event;
}
