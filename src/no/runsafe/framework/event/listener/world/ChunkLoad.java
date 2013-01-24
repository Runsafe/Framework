package no.runsafe.framework.event.listener.world;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.event.world.IChunkLoad;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

public final class ChunkLoad extends EventRouterBase<IChunkLoad, ChunkLoadEvent>
{
	public ChunkLoad(IOutput output, IScheduler scheduler, IChunkLoad handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(ChunkLoadEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(ChunkLoadEvent event)
	{
		handler.OnChunkLoad(ObjectWrapper.convert(event.getChunk()));
		return true;
	}

	public final class Factory implements EventRouterFactory
	{
		@Override
		public Class<? extends IRunsafeEvent> getInterface()
		{
			return IChunkLoad.class;
		}

		@Override
		public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
		{
			return new ChunkLoad(output, scheduler, (IChunkLoad) subscriber);
		}
	}
}
