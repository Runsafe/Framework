package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.player.IPlayerRightClickAirEvent;
import no.runsafe.framework.event.player.IPlayerRightClickBlockEvent;
import no.runsafe.framework.event.player.IPlayerRightClickEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerRightClick implements Listener
{
	public PlayerRightClick(IPlayerRightClickEvent subscriber)
	{
		eventSubscriber = subscriber;
	}

	@EventHandler
	public void OnEvent(PlayerInteractEvent event)
	{
		if (!(eventSubscriber instanceof IPlayerRightClickAirEvent || eventSubscriber instanceof IPlayerRightClickBlockEvent))
			eventSubscriber.OnPlayerRightClick(new RunsafePlayerClickEvent(event));

		else if (eventSubscriber instanceof IPlayerRightClickAirEvent && event.getAction() == Action.RIGHT_CLICK_AIR)
			eventSubscriber.OnPlayerRightClick(new RunsafePlayerClickEvent(event));

		else if (eventSubscriber instanceof IPlayerRightClickBlockEvent && event.getAction() == Action.RIGHT_CLICK_BLOCK)
			eventSubscriber.OnPlayerRightClick(new RunsafePlayerClickEvent(event));
	}

	private final IPlayerRightClickEvent eventSubscriber;
}
