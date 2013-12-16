package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.player.IPlayerCommandPreprocessEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerCommandPreprocessEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public final class CommandPreprocess extends EventRouterBase<IPlayerCommandPreprocessEvent, PlayerCommandPreprocessEvent>
{
	CommandPreprocess(IConsole output, IScheduler scheduler, IPlayerCommandPreprocessEvent handler)
	{
		super(output, scheduler, handler);
	}

	// This one cannot be async, so don't check
	@Override
	@EventHandler
	public void acceptEvent(PlayerCommandPreprocessEvent event)
	{
		onEvent(event);
	}

	@Override
	public boolean onEvent(PlayerCommandPreprocessEvent event)
	{
		handler.OnBeforePlayerCommand(new RunsafePlayerCommandPreprocessEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IPlayerCommandPreprocessEvent.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new CommandPreprocess(output, scheduler, (IPlayerCommandPreprocessEvent) subscriber);
			}
		};
	}
}
