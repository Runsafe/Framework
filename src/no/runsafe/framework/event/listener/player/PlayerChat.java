package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.player.IPlayerChatEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class PlayerChat implements Listener
{
    public PlayerChat(IPlayerChatEvent subscriber)
    {
        eventSubscriber = subscriber;
    }

    @EventHandler
    public void OnEvent(PlayerChatEvent event)
    {
        eventSubscriber.OnPlayerChatEvent(new RunsafePlayerChatEvent(event));
    }

    private final IPlayerChatEvent eventSubscriber;
}
