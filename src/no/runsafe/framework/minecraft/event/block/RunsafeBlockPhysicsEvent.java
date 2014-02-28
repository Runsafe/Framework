package no.runsafe.framework.minecraft.event.block;

import org.bukkit.event.block.BlockEvent;
import org.bukkit.event.block.BlockPhysicsEvent;

public class RunsafeBlockPhysicsEvent extends RunsafeCancellableBlockEvent
{
	public RunsafeBlockPhysicsEvent(BlockPhysicsEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	private final BlockPhysicsEvent event;
}
