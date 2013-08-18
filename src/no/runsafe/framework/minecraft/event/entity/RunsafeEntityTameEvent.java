package no.runsafe.framework.minecraft.event.entity;

import no.runsafe.framework.api.minecraft.IAnimalTamer;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.entity.EntityTameEvent;

public class RunsafeEntityTameEvent extends RunsafeCancellableEntityEvent
{
	public RunsafeEntityTameEvent(EntityTameEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public IAnimalTamer getOwner()
	{
		return ObjectWrapper.convert(event.getOwner());
	}

	private final EntityTameEvent event;
}
