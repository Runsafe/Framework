package no.runsafe.framework.minecraft.event.entity;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.block.RunsafeBlock;
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
		return ObjectWrapper.convert(event.getLocation());
	}

	public RunsafeBlock getBlock()
	{
		return getLocation().getBlock();
	}

	private final EntityPortalEnterEvent event;
}
