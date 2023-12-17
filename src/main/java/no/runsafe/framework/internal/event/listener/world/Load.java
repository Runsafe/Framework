package no.runsafe.framework.internal.event.listener.world;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.world.IWorldLoad;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;

public final class Load extends EventRouterBase<IWorldLoad, WorldLoadEvent>
{
	Load(IConsole output, IScheduler scheduler, IWorldLoad handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(WorldLoadEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(WorldLoadEvent event)
	{
		handler.OnWorldLoad(ObjectWrapper.convert(event.getWorld()));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IWorldLoad.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new Load(output, scheduler, (IWorldLoad) subscriber);
			}
		};
	}
}
