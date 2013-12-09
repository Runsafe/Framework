package no.runsafe.framework.internal.event.listener.world;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.world.IChunkLoad;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

public final class ChunkLoad extends EventRouterBase<IChunkLoad, ChunkLoadEvent>
{
	ChunkLoad(IConsole output, IScheduler scheduler, IChunkLoad handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(ChunkLoadEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(ChunkLoadEvent event)
	{
		handler.OnChunkLoad(ObjectWrapper.convert(event.getChunk()));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IChunkLoad.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new ChunkLoad(output, scheduler, (IChunkLoad) subscriber);
			}
		};
	}
}
