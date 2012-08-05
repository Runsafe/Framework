package no.runsafe.framework.server.event.player;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.event.player.PlayerJoinEvent;

public class RunsafePlayerJoinEvent extends RunsafePlayerEvent
{
	public RunsafePlayerJoinEvent(PlayerJoinEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafePlayer getPlayer()
	{
		return ObjectWrapper.convert(event.getPlayer());
	}

	public String getJoinMessage()
	{
		return event.getJoinMessage();
	}

	public void setJoinMessage(String message)
	{
		event.setJoinMessage(message);
	}

	private final PlayerJoinEvent event;
}
