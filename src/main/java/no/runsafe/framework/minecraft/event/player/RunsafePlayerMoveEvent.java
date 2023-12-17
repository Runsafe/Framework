package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerMoveEvent;

public class RunsafePlayerMoveEvent extends RunsafeCancellablePlayerEvent
{
	public RunsafePlayerMoveEvent(PlayerMoveEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public ILocation getFrom()
	{
		return ObjectWrapper.convert(event.getFrom());
	}

	public void setFrom(ILocation location)
	{
		event.setFrom((Location) ObjectUnwrapper.convert(location));
	}

	public ILocation getTo()
	{
		return ObjectWrapper.convert(event.getTo());
	}

	public void setTo(ILocation location)
	{
		event.setTo((Location) ObjectUnwrapper.convert(location));
	}

	private final PlayerMoveEvent event;
}
