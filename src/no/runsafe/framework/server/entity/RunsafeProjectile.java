package no.runsafe.framework.server.entity;

import no.runsafe.framework.wrapper.entity.BukkitProjectile;
import org.bukkit.entity.Projectile;

public class RunsafeProjectile extends BukkitProjectile
{
	public RunsafeProjectile(Projectile toWrap)
	{
		super(toWrap);
	}
}
