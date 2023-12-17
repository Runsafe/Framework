package no.runsafe.framework.minecraft.event.entity;

import org.bukkit.PortalType;
import org.bukkit.event.entity.EntityCreatePortalEvent;

public class RunsafeEntityCreatePortalEvent extends RunsafeCancellableEntityEvent
{
	public RunsafeEntityCreatePortalEvent(EntityCreatePortalEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public boolean isNetherPortal()
	{
		return event.getPortalType() == PortalType.NETHER;
	}

	public boolean isEnderPortal()
	{
		return event.getPortalType() == PortalType.ENDER;
	}

	public boolean isCustomPortal()
	{
		return event.getPortalType() == PortalType.CUSTOM;
	}

	private final EntityCreatePortalEvent event;
}
