package no.runsafe.framework.minecraft.event.block;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.block.RunsafeBlock;
import no.runsafe.framework.minecraft.event.RunsafeEvent;
import org.bukkit.event.block.BlockEvent;

public class RunsafeBlockEvent extends RunsafeEvent
{
	public RunsafeBlockEvent(BlockEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeBlock getBlock()
	{
		return ObjectWrapper.convert(this.event.getBlock());
	}

	private final BlockEvent event;
}
