package no.runsafe.framework.wrapper.entity;

import no.runsafe.framework.server.entity.RunsafeEntity;
import no.runsafe.framework.server.entity.RunsafeLivingEntity;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.entity.Projectile;
import org.bukkit.util.Vector;

public class BukkitProjectile extends RunsafeEntity
{
	public BukkitProjectile(Projectile toWrap)
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

	protected final Projectile projectile;
}
