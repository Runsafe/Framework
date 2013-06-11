package no.runsafe.framework.minecraft.event.block;

import org.bukkit.event.block.BlockRedstoneEvent;

public class RunsafeBlockRedstoneEvent extends RunsafeBlockEvent
{
	public RunsafeBlockRedstoneEvent(BlockRedstoneEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public int getOldCurrent()
	{
		return event.getOldCurrent();
	}

	public int getNewCurrent()
	{
		return event.getNewCurrent();
	}

	public void setNewCurrent(int newCurrent)
	{
		event.setNewCurrent(newCurrent);
	}

	private final BlockRedstoneEvent event;
}
