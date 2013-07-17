package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.internal.wrapper.entity.BukkitEntity;
import org.bukkit.entity.Entity;

public class RunsafeEntity extends BukkitEntity
{
	public RunsafeEntity(Entity toWrap)
	{
		super(toWrap);
	}

	public void strikeWithLightning(boolean effectOnly)
	{
		if (effectOnly)
			entity.getWorld().strikeLightningEffect(entity.getLocation());
		else
			entity.getWorld().strikeLightning(entity.getLocation());
	}

	public void explode(float power, boolean setFire, boolean breakBlocks)
	{
		entity.getWorld().createExplosion(
			entity.getLocation().getBlockX(),
			entity.getLocation().getBlockY(),
			entity.getLocation().getBlockZ(),
			power,
			setFire,
			breakBlocks
		);
	}
}
