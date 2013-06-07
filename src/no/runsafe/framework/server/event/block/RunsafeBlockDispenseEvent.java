package no.runsafe.framework.server.event.block;

import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.server.event.CancellableEvent;
import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.util.Vector;

public class RunsafeBlockDispenseEvent extends RunsafeBlockEvent implements CancellableEvent
{
	public RunsafeBlockDispenseEvent(BlockDispenseEvent toWrap)
	{
		super(toWrap);
		this.event = toWrap;
	}

	public RunsafeItemStack getItem()
	{
		return ObjectWrapper.convert(event.getItem());
	}

	public void setItem(RunsafeItemStack itemStack)
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

	private final BlockDispenseEvent event;
}
