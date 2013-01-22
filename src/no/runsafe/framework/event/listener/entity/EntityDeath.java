package no.runsafe.framework.event.listener.entity;

import no.runsafe.framework.event.EventEngine;
import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.event.entity.IEntityDeathEvent;
import no.runsafe.framework.event.listener.EventRouterBase;
import no.runsafe.framework.event.listener.EventRouterFactory;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.event.entity.RunsafeEntityDeathEvent;
import no.runsafe.framework.timer.IScheduler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeath extends EventRouterBase<IEntityDeathEvent, EntityDeathEvent>
{
	public EntityDeath(IOutput output, IScheduler scheduler, IEntityDeathEvent handler)
	{
		super(output, scheduler, handler);
	}

	@EventHandler
	@Override
	public void AcceptEvent(EntityDeathEvent event)
	{
		super.AcceptEvent(event);
	}

	@Override
	public boolean OnEvent(EntityDeathEvent entityDeathEvent)
	{
		handler.OnEntityDeath(new RunsafeEntityDeathEvent(entityDeathEvent));
		return true;
	}

	public static void Register()
	{
		EventEngine.Register(IEntityDeathEvent.class, new Factory());
	}

	private static class Factory implements EventRouterFactory
	{
		@Override
		public Listener getListener(IOutput output, IScheduler scheduler, IRunsafeEvent subscriber)
		{
			return new EntityDeath(output, scheduler, (IEntityDeathEvent) subscriber);
		}
	}
}
