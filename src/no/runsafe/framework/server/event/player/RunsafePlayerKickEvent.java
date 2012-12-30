package no.runsafe.framework.server.event.player;

import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerKickEvent;

public class RunsafePlayerKickEvent extends RunsafePlayerEvent
{
	public RunsafePlayerKickEvent(PlayerKickEvent toWrap)
	{
		super(toWrap);
		this.event = toWrap;
	}

	public String getLeaveMessage()
	{
		return this.event.getLeaveMessage();
	}

	public void setLeaveMessage(String message)
	{
		this.event.setLeaveMessage(message);
	}

	public String getReason()
	{
		return this.event.getReason();
	}

	public void setReason(String reason)
	{
		this.event.setReason(reason);
	}

	private final PlayerKickEvent event;
}
