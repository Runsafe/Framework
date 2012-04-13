package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.server.event.player.RunsafePlayerDropItemEvent;
import no.runsafe.framework.event.player.IPlayerDropItemEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class PlayerDropItem implements Listener
{
	public PlayerDropItem(IPlayerDropItemEvent subscriber)
	{
		eventSubscriber = subscriber;
	}

	@EventHandler
	public void OnEvent(PlayerDropItemEvent event)
	{
		eventSubscriber.OnPlayerDropItem(new RunsafePlayerDropItemEvent(event));
	}

	private IPlayerDropItemEvent eventSubscriber;
}
