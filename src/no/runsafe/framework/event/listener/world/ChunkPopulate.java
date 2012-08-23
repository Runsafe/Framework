package no.runsafe.framework.event.listener.world;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.world.IChunkPopulate;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.world.ChunkPopulateEvent;

public class ChunkPopulate extends EventRouter<IChunkPopulate, ChunkPopulateEvent>
{
	public ChunkPopulate(IOutput output, IScheduler scheduler, IChunkPopulate handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(ChunkPopulateEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(ChunkPopulateEvent event)
	{
		handler.OnChunkPopulate(ObjectWrapper.convert(event.getChunk()));
		return true;
	}
}
