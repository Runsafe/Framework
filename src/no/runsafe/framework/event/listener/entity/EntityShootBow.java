package no.runsafe.framework.event.listener.entity;

import no.runsafe.framework.event.entity.IEntityShootBowEvent;
import no.runsafe.framework.server.event.entity.RunsafeEntityShootBowEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class EntityShootBow implements Listener
{
    public EntityShootBow(IEntityShootBowEvent subscriber)
    {
        eventSubscriber = subscriber;
    }

    @EventHandler
    public void OnEvent(EntityShootBowEvent event)
    {
        eventSubscriber.OnEntityShootBowEvent(new RunsafeEntityShootBowEvent(event));
    }

    private IEntityShootBowEvent eventSubscriber;
}
