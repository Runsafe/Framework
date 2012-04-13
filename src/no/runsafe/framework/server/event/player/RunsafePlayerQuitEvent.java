package no.runsafe.framework.server.event.player;

import org.bukkit.event.player.PlayerQuitEvent;

public class RunsafePlayerQuitEvent extends RunsafePlayerEvent
{
	public RunsafePlayerQuitEvent(PlayerQuitEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public String getQuitMessage()
	{
		return event.getQuitMessage();
	}

	public void setQuitMessage(String message)
	{
		event.setQuitMessage(message);
	}

	private PlayerQuitEvent event;
}
