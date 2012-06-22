package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.server.event.player.RunsafePlayerTeleportEvent;
import no.runsafe.framework.event.player.IPlayerTeleportEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerTeleport implements Listener
{
	public PlayerTeleport(IPlayerTeleportEvent subscriber)
	{
		eventSubscriber = subscriber;
	}

	@EventHandler
	public void OnEvent(PlayerTeleportEvent event)
	{
		eventSubscriber.OnPlayerTeleport(new RunsafePlayerTeleportEvent(event));
	}

	private final IPlayerTeleportEvent eventSubscriber;
}
