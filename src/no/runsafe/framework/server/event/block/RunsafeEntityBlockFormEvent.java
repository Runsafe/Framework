package no.runsafe.framework.server.event.block;

import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.server.entity.RunsafeEntity;
import no.runsafe.framework.server.event.CancellableEvent;
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
