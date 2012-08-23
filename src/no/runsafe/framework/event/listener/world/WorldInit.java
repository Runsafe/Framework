package no.runsafe.framework.event.listener.world;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.world.IWorldInit;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.world.WorldInitEvent;

public class WorldInit extends EventRouter<IWorldInit, WorldInitEvent>
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
}