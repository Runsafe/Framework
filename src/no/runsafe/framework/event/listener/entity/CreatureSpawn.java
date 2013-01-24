package no.runsafe.framework.event.listener.entity;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.entity.IMobSpawnerPulsed;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public final class CreatureSpawn extends EventRouterBase<IMobSpawnerPulsed, CreatureSpawnEvent>
{
	public CreatureSpawn(IOutput output, IScheduler scheduler, IMobSpawnerPulsed handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(CreatureSpawnEvent event)
	{
		if (event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.SPAWNER))
			super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(CreatureSpawnEvent event)
	{
		return handler.OnMobSpawnerPulsed(
			ObjectWrapper.convert(event.getEntity()),
			ObjectWrapper.convert(event.getLocation())
		);
	}

	public final class Factory implements EventRouterFactory
	{
		@Override
		public Class<? extends IRunsafeEvent> getInterface()
		{
			return IMobSpawnerPulsed.class;
		}

		@Override
		public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
		{
			return new CreatureSpawn(output, scheduler, (IMobSpawnerPulsed) subscriber);
		}
	}
}
