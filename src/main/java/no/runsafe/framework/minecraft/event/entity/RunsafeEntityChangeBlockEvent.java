package no.runsafe.framework.minecraft.event.entity;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.Item;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class RunsafeEntityChangeBlockEvent extends RunsafeCancellableEntityEvent
{
	public RunsafeEntityChangeBlockEvent(EntityChangeBlockEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public IBlock getBlock()
	{
		return ObjectWrapper.convert(event.getBlock());
	}

	public Item getTo()
	{
		return Item.get(event.getTo(), (byte) 0);
	}

	public byte getData()
	{
		return event.getData();
	}

	private final EntityChangeBlockEvent event;
}
