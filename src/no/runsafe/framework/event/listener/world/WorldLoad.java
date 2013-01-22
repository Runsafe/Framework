package no.runsafe.framework.event.listener.world;

import no.runsafe.framework.event.EventEngine;
import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.event.world.IWorldLoad;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;

public class WorldLoad extends EventRouterBase<IWorldLoad, WorldLoadEvent>
{
	public WorldLoad(IOutput output, IScheduler scheduler, IWorldLoad handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(WorldLoadEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(WorldLoadEvent event)
	{
		handler.OnWorldLoad(ObjectWrapper.convert(event.getWorld()));
		return true;
	}

	public static void Register()
	{
		EventEngine.Register(IWorldLoad.class, new Factory());
	}

	private static class Factory implements EventRouterFactory
	{
		@Override
		public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
		{
			return new WorldLoad(output, scheduler, (IWorldLoad) subscriber);
		}
	}
}
