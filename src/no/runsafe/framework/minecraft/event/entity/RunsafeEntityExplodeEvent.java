package no.runsafe.framework.minecraft.event.entity;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.List;

public class RunsafeEntityExplodeEvent extends RunsafeCancellableEntityEvent
{
	public RunsafeEntityExplodeEvent(EntityExplodeEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public float getYield()
	{
		return event.getYield();
	}

	public void setYield(float yield)
	{
		event.setYield(yield);
	}

	public List<IBlock> getBlockList()
	{
		return ObjectWrapper.convert(event.blockList());
	}

	private final EntityExplodeEvent event;
}
