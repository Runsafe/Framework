package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class RunsafePlayerInteractEntityEvent extends RunsafeCancellablePlayerEvent
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

	private final PlayerInteractEntityEvent event;
}