package no.runsafe.framework.event.listener.world;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.world.IWorldUnload;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.world.WorldUnloadEvent;

public class WorldUnload extends EventRouter<IWorldUnload, WorldUnloadEvent>
{
	public WorldUnload(IScheduler scheduler, IWorldUnload handler)
	{
		super(scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(WorldUnloadEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public void OnEvent(WorldUnloadEvent event)
	{
		handler.OnWorldUnload(ObjectWrapper.convert(event.getWorld()));
	}
}
