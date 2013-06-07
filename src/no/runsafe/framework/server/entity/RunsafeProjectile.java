package no.runsafe.framework.server.entity;

import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.entity.Projectile;
import org.bukkit.util.Vector;

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

	public void setVelocity(Vector velocity)
	{
		projectile.setVelocity(velocity);
	}

	public boolean getBounce()
	{
		return projectile.doesBounce();
	}

	public void setBounce(boolean b)
	{
		projectile.setBounce(b);
	}

	private final Projectile projectile;
}
