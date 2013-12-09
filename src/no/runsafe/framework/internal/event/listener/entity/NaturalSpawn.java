package no.runsafe.framework.internal.event.listener.entity;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.entity.INaturalSpawn;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public final class NaturalSpawn extends EventRouterBase<INaturalSpawn, CreatureSpawnEvent>
{
	NaturalSpawn(IConsole output, IScheduler scheduler, INaturalSpawn handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(CreatureSpawnEvent event)
	{
		if (event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.NATURAL)
			super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(CreatureSpawnEvent event)
	{
		return !handler.OnNaturalSpawn(
			ObjectWrapper.convert(event.getEntity()),
			ObjectWrapper.convert(event.getLocation())
		);
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return INaturalSpawn.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new NaturalSpawn(output, scheduler, (INaturalSpawn) subscriber);
			}
		};
	}
}
