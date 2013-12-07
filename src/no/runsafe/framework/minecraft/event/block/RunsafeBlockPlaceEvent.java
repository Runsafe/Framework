package no.runsafe.framework.minecraft.event.block;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.block.BlockPlaceEvent;

public class RunsafeBlockPlaceEvent extends RunsafeCancellableBlockEvent
{
	public RunsafeBlockPlaceEvent(BlockPlaceEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	//Used in default MC spawn region, not linked to WorldGuard
	public boolean canBuild()
	{
		return event.canBuild();
	}

	public void setBuild(boolean canBuild)
	{
		event.setBuild(canBuild);
	}

	@Override
	public IBlock getBlock()
	{
		return ObjectWrapper.convert(event.getBlock());
	}

	public IBlock getBlockAgainst()
	{
		return ObjectWrapper.convert(event.getBlockAgainst());
	}

	public IBlock getBlockPlaced()
	{
		return ObjectWrapper.convert(event.getBlockPlaced());
	}

	public RunsafePlayer getPlayer()
	{
		return ObjectWrapper.convert((OfflinePlayer) event.getPlayer());
	}

	private final BlockPlaceEvent event;
}
