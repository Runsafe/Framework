package no.runsafe.framework.server.event.player;

import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class RunsafePlayerCommandPreprocessEvent extends RunsafePlayerChatEvent
{
	public RunsafePlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent toWrap)
	{
		super(toWrap);
	}
}
