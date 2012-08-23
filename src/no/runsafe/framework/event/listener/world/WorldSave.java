package no.runsafe.framework.event.listener.world;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.world.IWorldSave;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.world.WorldSaveEvent;

public class WorldSave extends EventRouter<IWorldSave, WorldSaveEvent>
{
	public WorldSave(IOutput output, IScheduler scheduler, IWorldSave handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(WorldSaveEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(WorldSaveEvent event)
	{
		handler.OnWorldSave(ObjectWrapper.convert(event.getWorld()));
		return true;
	}
}