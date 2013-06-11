package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.event.RunsafeEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.bukkit.event.player.PlayerEvent;

public class RunsafePlayerEvent extends RunsafeEvent
{
	public RunsafePlayerEvent(PlayerEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafePlayer getPlayer()
	{
		return ObjectWrapper.convert(event.getPlayer());
	}

	private final PlayerEvent event;
}
