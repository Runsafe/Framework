package no.runsafe.framework.internal.event.listener.block;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.block.IBlockPhysics;
import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.block.RunsafeBlockPhysicsEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

public final class Physics extends EventRouterBase<IBlockPhysics, BlockPhysicsEvent>
{
	Physics(IConsole output, IScheduler scheduler, IBlockPhysics handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(BlockPhysicsEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(BlockPhysicsEvent event)
	{
		handler.OnBlockPhysics(new RunsafeBlockPhysicsEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IBlockPhysics.class;
			}

			@Override
			public Listener getListener(IConsole output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new Physics(output, scheduler, (IBlockPhysics) subscriber);
			}
		};
	}
}