package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.event.player.IPlayerChatEvent;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerChatEvent;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public final class PlayerChat extends EventRouterBase<IPlayerChatEvent, AsyncPlayerChatEvent>
{
	PlayerChat(IOutput output, IScheduler scheduler, IPlayerChatEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	// This is async already, so no need to check..
	@Override
	public void acceptEvent(AsyncPlayerChatEvent event)
	{
		onEvent(event);
	}

	@Override
	public boolean onEvent(AsyncPlayerChatEvent event)
	{
		handler.OnPlayerChatEvent(new RunsafePlayerChatEvent(event));
		return true;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IPlayerChatEvent.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new PlayerChat(output, scheduler, (IPlayerChatEvent) subscriber);
			}
		};
	}
}
