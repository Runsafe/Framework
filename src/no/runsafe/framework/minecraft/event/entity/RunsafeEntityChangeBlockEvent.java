package no.runsafe.framework.minecraft.event.entity;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.block.RunsafeBlock;
import no.runsafe.framework.api.event.CancellableEvent;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class RunsafeEntityChangeBlockEvent extends RunsafeEntityEvent implements CancellableEvent
{
	public RunsafeEntityChangeBlockEvent(EntityChangeBlockEvent toWrap)
	{
		super(toWrap);
		this.event = toWrap;
	}

	public RunsafeBlock getBlock()
	{
		return ObjectWrapper.convert(this.event.getBlock());
	}

	public Item getTo()
	{
		return Item.get(this.event.getTo(), (byte) 0);
	}

	public byte getData()
	{
		return this.event.getData();
	}

	@Override
	public boolean getCancelled()
	{
		return this.event.isCancelled();
	}

	@Override
	public void setCancelled(boolean cancel)
	{
		this.event.setCancelled(cancel);
	}

	private final EntityChangeBlockEvent event;
}
