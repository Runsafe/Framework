package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.server.event.player.RunsafePlayerChangedWorldEvent;
import no.runsafe.framework.event.player.IPlayerChangedWorldEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class PlayerChangedWorld implements Listener
{
	public PlayerChangedWorld(IPlayerChangedWorldEvent subscriber)
	{
		eventSubscriber = subscriber;
	}

	@EventHandler
	public void OnEvent(PlayerChangedWorldEvent event)
	{
		eventSubscriber.OnPlayerChangedWorld(new RunsafePlayerChangedWorldEvent(event));
	}

	private final IPlayerChangedWorldEvent eventSubscriber;
}
