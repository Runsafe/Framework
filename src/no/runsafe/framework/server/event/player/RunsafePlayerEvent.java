package no.runsafe.framework.server.event.player;

import no.runsafe.framework.server.event.RunsafeEvent;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.event.player.PlayerEvent;

public class RunsafePlayerEvent extends RunsafeEvent
{
	public RunsafePlayerEvent(PlayerEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafePlayer getPlayer()
	{
		return new RunsafePlayer(event.getPlayer());
	}

	private final PlayerEvent event;
}
