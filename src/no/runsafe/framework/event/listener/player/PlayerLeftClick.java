package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.player.IPlayerLeftClickAirEvent;
import no.runsafe.framework.event.player.IPlayerLeftClickBlockEvent;
import no.runsafe.framework.event.player.IPlayerLeftClickEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerLeftClick implements Listener
{
	public PlayerLeftClick(IPlayerLeftClickEvent subscriber)
	{
		eventSubscriber = subscriber;
	}

	@EventHandler
	public void OnEvent(PlayerInteractEvent event)
	{
		if (!(eventSubscriber instanceof IPlayerLeftClickAirEvent || eventSubscriber instanceof IPlayerLeftClickBlockEvent))
			eventSubscriber.OnPlayerLeftClick(new RunsafePlayerClickEvent(event));

		else if (eventSubscriber instanceof IPlayerLeftClickAirEvent && event.getAction() == Action.LEFT_CLICK_AIR)
			eventSubscriber.OnPlayerLeftClick(new RunsafePlayerClickEvent(event));

		else if (eventSubscriber instanceof IPlayerLeftClickBlockEvent && event.getAction() == Action.LEFT_CLICK_BLOCK)
			eventSubscriber.OnPlayerLeftClick(new RunsafePlayerClickEvent(event));
	}

	private final IPlayerLeftClickEvent eventSubscriber;
}
