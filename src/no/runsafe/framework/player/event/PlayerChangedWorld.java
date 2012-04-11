package no.runsafe.framework.player.event;

import no.runsafe.framework.event.EventListener;
import no.runsafe.framework.player.RunsafePlayer;
import no.runsafe.framework.world.RunsafeWorld;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class PlayerChangedWorld extends EventListener<IPlayerChangedWorldEvent, PlayerChangedWorldEvent>
{
	public PlayerChangedWorld(IPlayerChangedWorldEvent iPlayerChangedWorldEvent)
	{
		super(iPlayerChangedWorldEvent);
	}

	@Override
	public void OnEvent(PlayerChangedWorldEvent playerChangedWorldEvent)
	{
		eventSubscriber.OnPlayerChangedWorld(
			new RunsafePlayer(playerChangedWorldEvent.getPlayer()),
			new RunsafeWorld(playerChangedWorldEvent.getFrom())
		);
	}
}
