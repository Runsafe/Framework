package no.runsafe.framework.minecraft.event.entity;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.RunsafeTravelAgent;
import org.bukkit.event.entity.EntityPortalEvent;

public class RunsafeEntityPortalEvent extends RunsafeEntityTeleportEvent
{
	public RunsafeEntityPortalEvent(EntityPortalEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public void useTravelAgent(boolean useTravelAgent)
	{
		event.useTravelAgent(useTravelAgent);
	}

	public boolean useTravelAgent()
	{
		return event.useTravelAgent();
	}

	public RunsafeTravelAgent getPortalTravelAgent()
	{
		return ObjectWrapper.convert(event.getPortalTravelAgent());
	}

	final EntityPortalEvent event;
}
