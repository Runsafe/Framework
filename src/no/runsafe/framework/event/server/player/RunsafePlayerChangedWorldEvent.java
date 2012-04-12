package no.runsafe.framework.event.server.player;

import no.runsafe.framework.world.RunsafeWorld;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class RunsafePlayerChangedWorldEvent extends RunsafePlayerEvent
{
	public RunsafePlayerChangedWorldEvent(PlayerChangedWorldEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeWorld getSourceWorld()
	{
		return new RunsafeWorld(event.getFrom());
	}

	private PlayerChangedWorldEvent event;
}
