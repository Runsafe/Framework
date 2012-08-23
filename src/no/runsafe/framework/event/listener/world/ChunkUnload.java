package no.runsafe.framework.event.listener.world;

import no.runsafe.framework.event.listener.EventRouter;
import no.runsafe.framework.event.world.IChunkUnload;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.world.ChunkUnloadEvent;

public class ChunkUnload extends EventRouter<IChunkUnload, ChunkUnloadEvent>
{
	public ChunkUnload(IOutput output, IScheduler scheduler, IChunkUnload handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(ChunkUnloadEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(ChunkUnloadEvent event)
	{
		handler.OnChunkUnload(ObjectWrapper.convert(event.getChunk()));
		return true;
	}
}
