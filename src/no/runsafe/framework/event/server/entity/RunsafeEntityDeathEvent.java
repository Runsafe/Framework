package no.runsafe.framework.event.server.entity;

import no.runsafe.framework.item.RunsafeItemStackList;
import org.bukkit.event.entity.EntityDeathEvent;

public class RunsafeEntityDeathEvent extends RunsafeEntityEvent
{
	public RunsafeEntityDeathEvent(EntityDeathEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeItemStackList getDrops()
	{
		return new RunsafeItemStackList(event.getDrops());
	}

	public int getDroppedXP()
	{
		return event.getDroppedExp();
	}

	public void setDroppedXP(int xp)
	{
		event.setDroppedExp(xp);
	}

	private EntityDeathEvent event;
}
