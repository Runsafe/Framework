package no.runsafe.framework.server.event.entity;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.entity.RunsafeEntity;
import org.bukkit.event.entity.EntityShootBowEvent;

public class RunsafeEntityShootBowEvent extends RunsafeEntityEvent
{
	public RunsafeEntityShootBowEvent(EntityShootBowEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public void setProjectile(RunsafeEntity entity)
	{
		event.setProjectile(entity.getRaw());
	}

	public RunsafeEntity getProjectile()
	{
		return ObjectWrapper.convert(event.getProjectile());
	}

	private final EntityShootBowEvent event;
}
