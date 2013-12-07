package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.event.RunsafeEvent;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.player.PlayerEvent;

public class RunsafePlayerEvent extends RunsafeEvent
{
	public RunsafePlayerEvent(PlayerEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public IPlayer getPlayer()
	{
		return ObjectWrapper.convert((OfflinePlayer) event.getPlayer());
	}

	private final PlayerEvent event;
}
