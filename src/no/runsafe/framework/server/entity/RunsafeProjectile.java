package no.runsafe.framework.server.entity;

import no.runsafe.framework.server.ObjectWrapper;
import org.bukkit.entity.Projectile;

public class RunsafeProjectile extends RunsafeEntity
{
	public RunsafeProjectile(Projectile toWrap)
	{
		super(toWrap);
		projectile = toWrap;
	}

	public RunsafeLivingEntity getShooter()
	{
		return ObjectWrapper.convert(projectile.getShooter());
	}

	public void setShooter(RunsafeLivingEntity livingEntity)
	{
		projectile.setShooter(livingEntity.getRaw());
	}

	public boolean getBounce()
	{
		return projectile.doesBounce();
	}

	public void setBounce(boolean b)
	{
		projectile.setBounce(b);
	}

	Projectile projectile;
}
