package no.runsafe.framework.server.entity;

import no.runsafe.framework.wrapper.entity.BukkitHumanEntity;
import org.bukkit.entity.HumanEntity;

public class RunsafeHumanEntity extends BukkitHumanEntity
{
	public RunsafeHumanEntity(HumanEntity toWrap)
	{
		super(toWrap);
	}
}
