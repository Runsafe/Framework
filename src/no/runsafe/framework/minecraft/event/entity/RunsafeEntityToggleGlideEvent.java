package no.runsafe.framework.minecraft.event.entity;

import org.bukkit.event.entity.EntityToggleGlideEvent;

public class RunsafeEntityToggleGlideEvent extends RunsafeCancellableEntityEvent
{
	public RunsafeEntityToggleGlideEvent(EntityToggleGlideEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public boolean isGliding()
	{
		return event.isGliding();
	}

	private final EntityToggleGlideEvent event;
}
