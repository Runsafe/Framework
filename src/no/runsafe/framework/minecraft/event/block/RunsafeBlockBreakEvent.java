package no.runsafe.framework.minecraft.event.block;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.bukkit.event.block.BlockBreakEvent;

public class RunsafeBlockBreakEvent extends RunsafeCancellableBlockEvent
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

	public void setXP(int xp)
	{
		event.setExpToDrop(xp);
	}

	private final BlockBreakEvent event;
}
