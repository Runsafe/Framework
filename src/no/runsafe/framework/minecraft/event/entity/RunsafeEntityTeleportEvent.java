package no.runsafe.framework.minecraft.event.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.entity.EntityTeleportEvent;

public class RunsafeEntityTeleportEvent extends RunsafeCancellableEntityEvent
{
	public RunsafeEntityTeleportEvent(EntityTeleportEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public ILocation getFrom()
	{
		return ObjectWrapper.convert(event.getFrom());
	}

	public void setFrom(ILocation from)
	{
		event.setFrom(ObjectUnwrapper.convert(from));
	}

	public ILocation getTo()
	{
		return ObjectWrapper.convert(event.getTo());
	}

	public void setTo(ILocation to)
	{
		event.setTo(ObjectUnwrapper.convert(to));
	}

	private final EntityTeleportEvent event;
}
