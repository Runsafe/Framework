package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.player.IPlayerChatEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerChatEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat extends EventRouter<IPlayerChatEvent, AsyncPlayerChatEvent>
{
	public PlayerChat(IScheduler scheduler, IPlayerChatEvent handler)
	{
		super(scheduler, handler);
	}

	// This is async already, so no need to check..
	@Override
	public void AcceptEvent(AsyncPlayerChatEvent event)
	{
		OnEvent(event);
	}

	@Override
	public void OnEvent(AsyncPlayerChatEvent event)
	{
		handler.OnPlayerChatEvent(new RunsafePlayerChatEvent(event));
	}
}
