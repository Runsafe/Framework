package no.runsafe.framework.internal.event.listener.world;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.event.world.IChunkUnload;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.api.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

public final class ChunkUnload extends EventRouterBase<IChunkUnload, ChunkUnloadEvent>
{
	private ChunkUnload(IOutput output, IScheduler scheduler, IChunkUnload handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(ChunkUnloadEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(ChunkUnloadEvent event)
	{
		handler.OnChunkUnload(ObjectWrapper.convert(event.getChunk()));
		return true;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IChunkUnload.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new ChunkUnload(output, scheduler, (IChunkUnload) subscriber);
			}
		};
	}
}
