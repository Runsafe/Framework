package no.runsafe.framework.server.event.entity;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.event.CancellableEvent;
import no.runsafe.framework.server.material.RunsafeMaterial;
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

	public RunsafeMaterial getTo()
	{
		return ObjectWrapper.convert(this.event.getTo());
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
