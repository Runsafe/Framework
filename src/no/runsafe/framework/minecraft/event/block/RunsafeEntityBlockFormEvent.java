package no.runsafe.framework.minecraft.event.block;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.api.event.CancellableEvent;
import org.bukkit.event.block.EntityBlockFormEvent;

public class RunsafeEntityBlockFormEvent extends RunsafeBlockEvent implements CancellableEvent
{
	public RunsafeEntityBlockFormEvent(EntityBlockFormEvent toWrap)
	{
		super(toWrap);
		this.event = toWrap;
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

	public RunsafeEntity getEntity()
	{
		return ObjectWrapper.convert(event.getEntity());
	}

	private final EntityBlockFormEvent event;
}
