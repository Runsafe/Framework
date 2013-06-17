package no.runsafe.framework.internal.event.listener.world;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.event.world.IWorldUnload;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldUnloadEvent;

public final class WorldUnload extends EventRouterBase<IWorldUnload, WorldUnloadEvent>
{
	public WorldUnload(IOutput output, IScheduler scheduler, IWorldUnload handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(WorldUnloadEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(WorldUnloadEvent event)
	{
		handler.OnWorldUnload(ObjectWrapper.convert(event.getWorld()));
		return true;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IWorldUnload.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new WorldUnload(output, scheduler, (IWorldUnload) subscriber);
			}
		};
	}
}
