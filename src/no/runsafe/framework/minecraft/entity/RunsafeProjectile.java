package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.internal.wrapper.entity.BukkitProjectile;
import org.bukkit.entity.Projectile;

public class RunsafeProjectile extends BukkitProjectile
{
	public RunsafeProjectile(Projectile toWrap)
	{
		super(toWrap);
	}
}
