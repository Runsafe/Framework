package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.server.event.player.RunsafePlayerQuitEvent;
import no.runsafe.framework.event.player.IPlayerQuitEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener
{
	public PlayerQuit(IPlayerQuitEvent subscriber)
	{
		eventSubscriber = subscriber;
	}

	@EventHandler
	public void OnEvent(PlayerQuitEvent event)
	{
		eventSubscriber.OnPlayerQuit(new RunsafePlayerQuitEvent(event));
	}

	private IPlayerQuitEvent eventSubscriber;
}
