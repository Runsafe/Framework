package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.player.IPlayerJoinEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerJoinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.PriorityQueue;

public class PlayerJoin implements Listener
{
    public PlayerJoin(IPlayerJoinEvent subscriber)
    {
        eventSubscriber = subscriber;
    }

    @EventHandler
    public void OnEvent(PlayerJoinEvent event)
    {
        eventSubscriber.OnPlayerJoinEvent(new RunsafePlayerJoinEvent(event));
    }

    private IPlayerJoinEvent eventSubscriber;
}
