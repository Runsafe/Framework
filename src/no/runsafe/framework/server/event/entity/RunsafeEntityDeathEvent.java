package no.runsafe.framework.server.event.entity;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.List;

public class RunsafeEntityDeathEvent extends RunsafeEntityEvent
{
	public RunsafeEntityDeathEvent(EntityDeathEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public List<RunsafeItemStack> getDrops()
	{
		return ObjectWrapper.convert(event.getDrops());
	}

	public int getDroppedXP()
	{
		return event.getDroppedExp();
	}

	public void setDroppedXP(int xp)
	{
		event.setDroppedExp(xp);
	}

	private final EntityDeathEvent event;
}
