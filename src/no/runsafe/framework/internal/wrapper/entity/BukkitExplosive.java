package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import org.bukkit.entity.Explosive;

public class BukkitExplosive extends RunsafeEntity
{
	public BukkitExplosive(Explosive toWrap)
	{
		super(toWrap);
		explosive = toWrap;
	}

	public void setYield(float yield)
	{
		explosive.setYield(yield);
	}

	public float getYield()
	{
		return explosive.getYield();
	}

	public void setIsIncendiary(boolean incendiary)
	{
		explosive.setIsIncendiary(incendiary);
	}

	public boolean isIncendiary()
	{
		return explosive.isIncendiary();
	}

	private final Explosive explosive;
}
