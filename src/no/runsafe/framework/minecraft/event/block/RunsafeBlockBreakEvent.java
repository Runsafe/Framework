package no.runsafe.framework.minecraft.event.block;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.api.event.CancellableEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.bukkit.event.block.BlockBreakEvent;

public class RunsafeBlockBreakEvent extends RunsafeBlockEvent implements CancellableEvent
{
	public RunsafeBlockBreakEvent(BlockBreakEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafePlayer getPlayer()
	{
		return ObjectWrapper.convert(event.getPlayer());
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

	public void setXP(int xp)
	{
		event.setExpToDrop(xp);
	}

	private final BlockBreakEvent event;
}
