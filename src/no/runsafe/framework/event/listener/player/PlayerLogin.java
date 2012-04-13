package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.server.event.player.RunsafePlayerLoginEvent;
import no.runsafe.framework.event.player.IPlayerLoginEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLogin implements Listener
{
	public PlayerLogin(IPlayerLoginEvent subscriber)
	{
		eventSubscriber = subscriber;
	}

	@EventHandler
	public void OnEvent(PlayerLoginEvent event)
	{
		eventSubscriber.OnPlayerLogin(new RunsafePlayerLoginEvent(event));
	}

	private IPlayerLoginEvent eventSubscriber;
}
