package no.runsafe.framework.minecraft.event.block;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import org.bukkit.event.block.EntityBlockFormEvent;

public class RunsafeEntityBlockFormEvent extends RunsafeCancellableBlockEvent
{
	public RunsafeEntityBlockFormEvent(EntityBlockFormEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeEntity getEntity()
	{
		return ObjectWrapper.convert(event.getEntity());
	}

	private final EntityBlockFormEvent event;
}
