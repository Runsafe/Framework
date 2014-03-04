package no.runsafe.framework.internal.event.listener.world;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IMapInitializeEvent;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.MapInitializeEvent;

public final class MapInitialize extends EventRouterBase<IMapInitializeEvent, MapInitializeEvent>
{
	MapInitialize(IConsole output, IScheduler scheduler, IMapInitializeEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(MapInitializeEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(MapInitializeEvent event)
	{
		handler.OnMapInitialize(event.getMap());
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IMapInitializeEvent.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new MapInitialize(output, scheduler, (IMapInitializeEvent) subscriber);
			}
		};
	}
}

