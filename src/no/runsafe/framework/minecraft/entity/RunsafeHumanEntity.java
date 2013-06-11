package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.internal.wrapper.entity.BukkitHumanEntity;
import org.bukkit.entity.HumanEntity;

public class RunsafeHumanEntity extends BukkitHumanEntity
{
	public RunsafeHumanEntity(HumanEntity toWrap)
	{
		super(toWrap);
	}
}
