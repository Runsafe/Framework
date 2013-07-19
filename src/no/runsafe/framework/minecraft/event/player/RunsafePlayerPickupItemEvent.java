package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeItem;
import org.bukkit.event.Cancellable;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class RunsafePlayerPickupItemEvent extends RunsafePlayerEvent implements Cancellable
{
	public RunsafePlayerPickupItemEvent(PlayerPickupItemEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeItem getItem()
	{
		return ObjectWrapper.convert(event.getItem());
	}

	public int getRemaining()
	{
		return event.getRemaining();
	}

	@Override
	public boolean isCancelled()
	{
		return event.isCancelled();
	}

	@Override
	public void setCancelled(boolean cancel)
	{
		event.setCancelled(cancel);
	}

	private final PlayerPickupItemEvent event;
}
