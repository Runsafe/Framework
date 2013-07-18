package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.RunsafeLocation;
import org.bukkit.event.player.PlayerMoveEvent;

public class RunsafePlayerMoveEvent extends RunsafeCancellablePlayerEvent
{
	public RunsafePlayerMoveEvent(PlayerMoveEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeLocation getFrom()
	{
		return ObjectWrapper.convert(event.getFrom());
	}

	public void setFrom(RunsafeLocation location)
	{
		event.setFrom(location.getRaw());
	}

	public RunsafeLocation getTo()
	{
		return ObjectWrapper.convert(event.getTo());
	}

	public void setTo(RunsafeLocation location)
	{
		event.setTo(location.getRaw());
	}

	private final PlayerMoveEvent event;
}
