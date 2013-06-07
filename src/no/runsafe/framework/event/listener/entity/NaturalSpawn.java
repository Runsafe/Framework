package no.runsafe.framework.event.listener.entity;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.entity.INaturalSpawn;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class NaturalSpawn extends EventRouterBase<INaturalSpawn, CreatureSpawnEvent>
{
	public NaturalSpawn(IOutput output, IScheduler scheduler, INaturalSpawn handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(CreatureSpawnEvent event)
	{
		if (event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.NATURAL))
			super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(CreatureSpawnEvent event)
	{
		return handler.OnNaturalSpawn(
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
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new NaturalSpawn(output, scheduler, (INaturalSpawn) subscriber);
			}
		};
	}
}
