package no.runsafe.framework.internal.event.listener.world;

import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.event.world.IWorldInit;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;

public final class Init extends EventRouterBase<IWorldInit, WorldInitEvent>
{
	Init(IConsole output, IScheduler scheduler, IWorldInit handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(WorldInitEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(WorldInitEvent event)
	{
		handler.OnWorldInit(ObjectWrapper.convert(event.getWorld()));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IWorldInit.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new Init(output, scheduler, (IWorldInit) subscriber);
			}
		};
	}
}
