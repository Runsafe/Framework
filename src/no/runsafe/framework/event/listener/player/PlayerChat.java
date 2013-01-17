package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.EventEngine;
import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.event.player.IPlayerChatEvent;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.player.RunsafePlayerChatEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChat extends EventRouter<IPlayerChatEvent, AsyncPlayerChatEvent>
{
	public PlayerChat(IOutput output, IScheduler scheduler, IPlayerChatEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	// This is async already, so no need to check..
	@Override
	public void AcceptEvent(AsyncPlayerChatEvent event)
	{
		OnEvent(event);
	}

	@Override
	public boolean OnEvent(AsyncPlayerChatEvent event)
	{
		handler.OnPlayerChatEvent(new RunsafePlayerChatEvent(event));
		return true;
	}

	static
	{
		EventEngine.Register(IPlayerChatEvent.class, new EventRouterFactory()
		{
			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PlayerChat(output, scheduler, (IPlayerChatEvent) subscriber);
			}
		});
	}
}
