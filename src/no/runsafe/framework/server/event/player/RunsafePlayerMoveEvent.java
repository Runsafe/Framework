package no.runsafe.framework.server.event.player;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.event.CancellableEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class RunsafePlayerMoveEvent extends RunsafePlayerEvent implements CancellableEvent
{
	public RunsafePlayerMoveEvent(PlayerMoveEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
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
