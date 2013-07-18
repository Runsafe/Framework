package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.RunsafeTravelAgent;
import org.bukkit.event.player.PlayerPortalEvent;

public class RunsafePlayerPortalEvent extends RunsafePlayerTeleportEvent
{
	public RunsafePlayerPortalEvent(PlayerPortalEvent toWrap)
	{
		super(toWrap);
		this.event = toWrap;
	}

	public void useTravelAgent(boolean useTravelAgent)
	{
		this.event.useTravelAgent(useTravelAgent);
	}

	public boolean useTravelAgent()
	{
		return this.event.useTravelAgent();
	}

	public RunsafeTravelAgent getPortalTravelAgent()
	{
		return ObjectWrapper.convert(this.event.getPortalTravelAgent());
	}

	public void setPortalTravelAgent(RunsafeTravelAgent travelAgent)
	{
		this.event.setPortalTravelAgent(travelAgent.getRaw());
	}

	private final PlayerPortalEvent event;
}
