package no.runsafe.framework.internal.event.listener.world;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IDebug;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.world.IWorldSave;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldSaveEvent;

public final class WorldSave extends EventRouterBase<IWorldSave, WorldSaveEvent>
{
	WorldSave(IDebug output, IScheduler scheduler, IWorldSave handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(WorldSaveEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(WorldSaveEvent event)
	{
		handler.OnWorldSave(ObjectWrapper.convert(event.getWorld()));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IWorldSave.class;
			}

			@Override
			public Listener getListener(IDebug output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new WorldSave(output, scheduler, (IWorldSave) subscriber);
			}
		};
	}
}
