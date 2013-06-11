package no.runsafe.framework.minecraft.event.entity;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class RunsafeEntityDamageByEntityEvent extends RunsafeEntityDamageEvent
{
	public RunsafeEntityDamageByEntityEvent(EntityDamageByEntityEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeEntity getDamageActor()
	{
		return ObjectWrapper.convert(event.getDamager());
	}

	private final EntityDamageByEntityEvent event;
}
