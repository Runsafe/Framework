package no.runsafe.framework.event.server.player;

import no.runsafe.framework.world.RunsafeWorld;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class RunafePlayerChangedWorldEvent extends RunsafePlayerEvent
{
	public RunafePlayerChangedWorldEvent(PlayerChangedWorldEvent toWrap)
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
