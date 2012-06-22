package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.server.event.player.RunsafePlayerCommandPreprocessEvent;
import no.runsafe.framework.event.player.IPlayerCommandPreprocessEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerCommandPreprocess implements Listener
{
	public PlayerCommandPreprocess(IPlayerCommandPreprocessEvent subscriber)
	{
		eventSubscriber = subscriber;
	}

	@EventHandler
	public void OnEvent(PlayerCommandPreprocessEvent event)
	{
		eventSubscriber.OnBeforePlayerCommand(new RunsafePlayerCommandPreprocessEvent(event));
	}

	private final IPlayerCommandPreprocessEvent eventSubscriber;
}
