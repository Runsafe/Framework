package no.runsafe.framework.internal.event.listener.world;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.world.IChunkUnload;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkUnloadEvent;

public final class ChunkUnload extends EventRouterBase<IChunkUnload, ChunkUnloadEvent>
{
	ChunkUnload(IConsole output, IScheduler scheduler, IChunkUnload handler)
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
		return false;
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
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new ChunkUnload(output, scheduler, (IChunkUnload) subscriber);
			}
		};
	}
}
