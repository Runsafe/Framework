package no.runsafe.framework.event.listener.world;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.world.IChunkLoad;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.world.ChunkLoadEvent;

public class ChunkLoad extends EventRouter<IChunkLoad, ChunkLoadEvent>
{
	public ChunkLoad(IScheduler scheduler, IChunkLoad handler)
	{
		super(scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(ChunkLoadEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public void OnEvent(ChunkLoadEvent event)
	{
		handler.OnChunkLoad(ObjectWrapper.convert(event.getChunk()));
	}
}
