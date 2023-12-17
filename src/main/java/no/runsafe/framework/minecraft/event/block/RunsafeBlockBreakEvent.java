package no.runsafe.framework.minecraft.event.block;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.block.BlockBreakEvent;

public class RunsafeBlockBreakEvent extends RunsafeCancellableBlockEvent
{
	public RunsafeBlockBreakEvent(BlockBreakEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public IPlayer getPlayer()
	{
		return ObjectWrapper.convert((OfflinePlayer) event.getPlayer());
	}

	public void setXP(int xp)
	{
		event.setExpToDrop(xp);
	}

	private final BlockBreakEvent event;
}
