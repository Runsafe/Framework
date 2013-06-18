package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.entity.RunsafeLivingEntity;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.entity.Projectile;
import org.bukkit.util.Vector;

public abstract class BukkitProjectile extends RunsafeEntity
{
	protected BukkitProjectile(Projectile toWrap)
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

	@Override
	public Projectile getRaw()
	{
		return projectile;
	}

	protected final Projectile projectile;
}
