package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.RunsafeTravelAgent;
import org.bukkit.event.player.PlayerPortalEvent;

public class RunsafePlayerPortalEvent extends RunsafePlayerTeleportEvent
{
	public RunsafePlayerPortalEvent(PlayerPortalEvent toWrap)
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

	public void setPortalTravelAgent(RunsafeTravelAgent travelAgent)
	{
		event.setPortalTravelAgent(travelAgent.getRaw());
	}

	private final PlayerPortalEvent event;
}
