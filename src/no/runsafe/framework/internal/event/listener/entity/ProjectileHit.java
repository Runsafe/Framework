package no.runsafe.framework.internal.event.listener.entity;

import no.runsafe.framework.api.EventRouterFactory;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.IScheduler;
import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.event.entity.IProjectileHitEvent;
import no.runsafe.framework.internal.event.listener.EventRouterBase;
import no.runsafe.framework.minecraft.event.entity.RunsafeProjectileHitEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ProjectileHit extends EventRouterBase<IProjectileHitEvent, ProjectileHitEvent>
{
	ProjectileHit(IOutput output, IScheduler scheduler, IProjectileHitEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void acceptEvent(ProjectileHitEvent event)
	{
		super.acceptEvent(event);
	}

	@Override
	public boolean onEvent(ProjectileHitEvent event)
	{
		handler.OnProjectileHit(new RunsafeProjectileHitEvent(event));
		return false;
	}

	public static EventRouterFactory Factory()
	{
		return new EventRouterFactory()
		{
			@Override
			public Class<? extends IRunsafeEvent> getInterface()
			{
				return IProjectileHitEvent.class;
			}

			@Override
			public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
			{
				return new ProjectileHit(output, scheduler, (IProjectileHitEvent) subscriber);
			}
		};
	}
}
