package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.api.event.CancellableEvent;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
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