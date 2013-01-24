package no.runsafe.framework.event.listener.world;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.event.world.ISpawnChange;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.SpawnChangeEvent;

public final class SpawnChange extends EventRouterBase<ISpawnChange, SpawnChangeEvent>
{
	public SpawnChange(IOutput output, IScheduler scheduler, ISpawnChange handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(SpawnChangeEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(SpawnChangeEvent event)
	{
		handler.OnSpawnChange(
			ObjectWrapper.convert(event.getWorld()),
			ObjectWrapper.convert(event.getPreviousLocation())
		);
		return true;
	}

	public final static class Factory implements EventRouterFactory
	{
		@Override
		public Class<? extends IRunsafeEvent> getInterface()
		{
			return ISpawnChange.class;
		}

		@Override
		public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
		{
			return new SpawnChange(output, scheduler, (ISpawnChange) subscriber);
		}
	}
}
