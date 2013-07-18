package no.runsafe.framework.minecraft.event.block;

import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.util.Vector;

public class RunsafeBlockDispenseEvent extends RunsafeCancellableBlockEvent
{
	public RunsafeBlockDispenseEvent(BlockDispenseEvent toWrap)
	{
		super(toWrap);
		this.event = toWrap;
	}

	public RunsafeMeta getItem()
	{
		return ObjectWrapper.convert(event.getItem());
	}

	public void setItem(RunsafeMeta itemStack)
	{
		event.setItem(itemStack.getRaw());
	}

	public Vector getVelocity()
	{
		return event.getVelocity();
	}

	public void setVelocity(Vector velocity)
	{
		event.setVelocity(velocity);
	}

	private final BlockDispenseEvent event;
}
