package no.runsafe.framework.minecraft.event.entity;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.event.RunsafeEvent;
import org.bukkit.event.entity.EntityEvent;

public class RunsafeEntityEvent extends RunsafeEvent
{
	public RunsafeEntityEvent(EntityEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeEntity getEntity()
	{
		return ObjectWrapper.convert(event.getEntity());
	}

	private final EntityEvent event;
}
