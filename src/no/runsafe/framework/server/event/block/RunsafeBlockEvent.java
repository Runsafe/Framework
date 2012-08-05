package no.runsafe.framework.server.event.block;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.event.RunsafeEvent;
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
