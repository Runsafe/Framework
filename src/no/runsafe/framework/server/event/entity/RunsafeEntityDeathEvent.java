package no.runsafe.framework.server.event.entity;

import no.runsafe.framework.server.item.meta.RunsafeMeta;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.List;

public class RunsafeEntityDeathEvent extends RunsafeEntityEvent
{
	public RunsafeEntityDeathEvent(EntityDeathEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public List<RunsafeMeta> getDrops()
	{
		return ObjectWrapper.convert(event.getDrops());
	}

	public void setDrops(List<RunsafeMeta> items)
	{
		this.event.getDrops().clear();

		for (RunsafeMeta itemStack : items)
			this.event.getDrops().add(itemStack.getRaw());
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
