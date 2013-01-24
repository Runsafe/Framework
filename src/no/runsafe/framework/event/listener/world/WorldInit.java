package no.runsafe.framework.event.listener.world;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.event.world.IWorldInit;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;

public final class WorldInit extends EventRouterBase<IWorldInit, WorldInitEvent>
{
	public WorldInit(IOutput output, IScheduler scheduler, IWorldInit handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(WorldInitEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(WorldInitEvent event)
	{
		handler.OnWorldInit(ObjectWrapper.convert(event.getWorld()));
		return true;
	}

	public final class Factory implements EventRouterFactory
	{
		@Override
		public Class<? extends IRunsafeEvent> getInterface()
		{
			return IWorldInit.class;
		}

		@Override
		public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
		{
			return new WorldInit(output, scheduler, (IWorldInit) subscriber);
		}
	}
}
