package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.player.IPlayerInteractEntityEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerInteractEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class PlayerInteractEntity implements Listener
{
    public PlayerInteractEntity(IPlayerInteractEntityEvent subscriber)
    {
        this.eventSubscriber = subscriber;
    }

    @EventHandler
    public void OnEvent(PlayerInteractEntityEvent event)
    {
        this.eventSubscriber.OnPlayerInteractEntityEvent(new RunsafePlayerInteractEntityEvent(event));
    }

    private final IPlayerInteractEntityEvent eventSubscriber;
}
