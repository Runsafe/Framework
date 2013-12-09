package no.runsafe.framework.internal.event.listener.world;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IDebug;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.world.IChunkPopulate;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkPopulateEvent;

public final class ChunkPopulate extends EventRouterBase<IChunkPopulate, ChunkPopulateEvent>
{
	ChunkPopulate(IDebug output, IScheduler scheduler, IChunkPopulate handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(ChunkPopulateEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(ChunkPopulateEvent event)
	{
		handler.OnChunkPopulate(ObjectWrapper.convert(event.getChunk()));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IChunkPopulate.class;
			}

			@Override
			public Listener getListener(IDebug output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new ChunkPopulate(output, scheduler, (IChunkPopulate) subscriber);
			}
		};
	}
}
