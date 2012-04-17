package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.player.IPlayerInteractEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerInteractEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteract  implements Listener
{
    public PlayerInteract(IPlayerInteractEvent subscriber)
    {
        eventSubscriber = subscriber;
    }

    @EventHandler
    public void OnEvent(PlayerInteractEvent event)
    {
        eventSubscriber.OnPlayerInteractEvent(new RunsafePlayerInteractEvent(event));
    }

    private IPlayerInteractEvent eventSubscriber;
}
