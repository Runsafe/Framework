package no.runsafe.framework.server.event.player;

import no.runsafe.framework.server.entity.RunsafeEntity;
import no.runsafe.framework.server.event.CancellableEvent;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class RunsafePlayerInteractEntityEvent extends RunsafePlayerEvent implements CancellableEvent
{
	public RunsafePlayerInteractEntityEvent(PlayerInteractEntityEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeEntity getRightClicked()
	{
		return ObjectWrapper.convert(this.event.getRightClicked());
	}

	@Override
	public boolean getCancelled()
	{
		return event.isCancelled();
	}

	@Override
	public void setCancelled(boolean cancel)
	{
		event.setCancelled(cancel);
	}

	private final PlayerInteractEntityEvent event;
}