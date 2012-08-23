package no.runsafe.framework.event.listener.world;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.world.ISpawnChange;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.world.SpawnChangeEvent;

public class SpawnChange extends EventRouter<ISpawnChange, SpawnChangeEvent>
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
}