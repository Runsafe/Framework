package no.runsafe.framework.internal.event.listener.world;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.world.ISpawnChange;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.SpawnChangeEvent;

public final class SpawnChange extends EventRouterBase<ISpawnChange, SpawnChangeEvent>
{
	SpawnChange(IDebug output, IScheduler scheduler, ISpawnChange handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(SpawnChangeEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(SpawnChangeEvent event)
	{
		handler.OnSpawnChange(
			ObjectWrapper.convert(event.getWorld()),
			ObjectWrapper.convert(event.getPreviousLocation())
		);
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return ISpawnChange.class;
			}

			@Override
			public Listener getListener(IDebug output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new SpawnChange(output, scheduler, (ISpawnChange) subscriber);
			}
		};
	}
}
