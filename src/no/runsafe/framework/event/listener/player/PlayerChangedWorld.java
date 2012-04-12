package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.subscriber.player.IPlayerChangedWorldEvent;
import no.runsafe.framework.player.RunsafePlayer;
import no.runsafe.framework.world.RunsafeWorld;
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
	public void OnEvent(PlayerChangedWorldEvent playerChangedWorldEvent)
	{
		eventSubscriber.OnPlayerChangedWorld(
			new RunsafePlayer(playerChangedWorldEvent.getPlayer()),
			new RunsafeWorld(playerChangedWorldEvent.getFrom())
		);
	}

	private IPlayerChangedWorldEvent eventSubscriber;
}
