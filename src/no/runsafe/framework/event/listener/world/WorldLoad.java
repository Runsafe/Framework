package no.runsafe.framework.event.listener.world;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.world.IWorldLoad;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.world.WorldLoadEvent;

public class WorldLoad extends EventRouter<IWorldLoad, WorldLoadEvent>
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
}
