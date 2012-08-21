package no.runsafe.framework.event.listener.world;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.world.IWorldInit;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.world.WorldInitEvent;

public class WorldInit extends EventRouter<IWorldInit, WorldInitEvent>
{
	public WorldInit(IScheduler scheduler, IWorldInit handler)
	{
		super(scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(WorldInitEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public void OnEvent(WorldInitEvent event)
	{
		handler.OnWorldInit(ObjectWrapper.convert(event.getWorld()));
	}
}
