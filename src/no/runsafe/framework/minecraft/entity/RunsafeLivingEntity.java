package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.entity.ILivingEntity;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.internal.wrapper.entity.BukkitProjectile;
import no.runsafe.framework.minecraft.Buff;
import no.runsafe.framework.minecraft.inventory.RunsafeEntityEquipment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;
import java.util.List;

public class RunsafeLivingEntity extends RunsafeEntity implements ILivingEntity
{
	//public static final int MAX_DISTANCE = 300; // ToDo: Check if we use this?

	public RunsafeLivingEntity(LivingEntity toWrap)
	{
		super(toWrap);
		entity = toWrap;
	}

	@Override
	public List<Buff> getActivePotionEffects()
	{
		return ObjectWrapper.convert(entity.getActivePotionEffects());
	}

	@Override
	public boolean getCanPickupItems()
	{
		return entity.getCanPickupItems();
	}

	@Override
	public String getCustomName()
	{
		return entity.getCustomName();
	}

	@Override
	public RunsafeEntityEquipment getEquipment()
	{
		return ObjectWrapper.convert(entity.getEquipment());
	}

	@Override
	public double getEyeHeight()
	{
		return entity.getEyeHeight();
	}

	@Override
	public double getEyeHeight(boolean ignoreSneaking)
	{
		return entity.getEyeHeight(ignoreSneaking);
	}

	@Override
	public ILocation getEyeLocation()
	{
		return ObjectWrapper.convert(entity.getEyeLocation());
	}

	@Override
	public IPlayer getKiller()
	{
		return ObjectWrapper.convert(entity.getKiller());
	}

	@Override
	public double getLastDamage()
	{
		return entity.getLastDamage();
	}

	@Override
	public IEntity getLeashHolder()
	{
		return ObjectWrapper.convert(entity.getLeashHolder());
	}

	@Override
	public int getMaximumAir()
	{
		return entity.getMaximumAir();
	}

	@Override
	public int getMaximumNoDamageTicks()
	{
		return entity.getMaximumNoDamageTicks();
	}

	@Override
	public int getNoDamageTicks()
	{
		return entity.getNoDamageTicks();
	}

	@Override
	public int getRemainingAir()
	{
		return entity.getRemainingAir();
	}

	@Override
	public boolean getRemoveWhenFarAway()
	{
		return entity.getRemoveWhenFarAway();
	}

	@Override
	public boolean hasLineOfSight(IEntity target)
	{
		return entity.hasLineOfSight((Entity) ObjectUnwrapper.convert(target));
	}

	@Override
	public boolean hasPotionEffect(Buff type)
	{
		return entity.hasPotionEffect(type.getType());
	}

	@Override
	public boolean isCustomNameVisible()
	{
		return entity.isCustomNameVisible();
	}

	@Override
	public boolean isLeashed()
	{
		return entity.isLeashed();
	}

	@Override
	@Nullable
	public IEntity launchProjectile(ProjectileEntity launchEntity)
	{
		if (!Projectile.class.isAssignableFrom(launchEntity.getEntityType()))
			return null;

		IEntity projectile = ObjectWrapper.convert(entity.launchProjectile(launchEntity.getClass().asSubclass(Projectile.class)));

		// ToDo: Refactor this? IEntity cannot be cast to bukkit Projectile, so this has never worked.
		if (projectile instanceof Projectile)
			((Projectile) projectile).setShooter(entity);

		return projectile;
	}

	@Override
	public void addBuff(Buff buff)
	{
		entity.addPotionEffect(buff.getEffect());
	}

	@Override
	public void removeBuff(Buff buff)
	{
		entity.removePotionEffect(buff.getType());
	}

	@Override
	public void setCanPickupItems(boolean pickup)
	{
		entity.setCanPickupItems(pickup);
	}

	@Override
	public void setCustomName(String name)
	{
		entity.setCustomName(name);
	}

	@Override
	public void setCustomNameVisible(boolean visible)
	{
		entity.setCustomNameVisible(visible);
	}

	@Override
	public void setLastDamage(double damage)
	{
		entity.setLastDamage(damage);
	}

	@Override
	public boolean setLeashHolder(IEntity holder)
	{
		return entity.setLeashHolder((Entity) ObjectUnwrapper.convert(holder));
	}

	@Override
	public void setMaximumAir(int ticks)
	{
		entity.setMaximumAir(ticks);
	}

	@Override
	public void setMaximumNoDamageTicks(int ticks)
	{
		entity.setMaximumNoDamageTicks(ticks);
	}

	@Override
	public void setNoDamageTicks(int ticks)
	{
		entity.setNoDamageTicks(ticks);
	}

	@Override
	public void setRemainingAir(int ticks)
	{
		entity.setRemainingAir(ticks);
	}

	@Override
	public void setRemoveWhenFarAway(boolean remove)
	{
		entity.setRemoveWhenFarAway(remove);
	}

	@Override
	public void removeAllBuffs()
	{
		for (PotionEffect effect : entity.getActivePotionEffects())
			entity.removePotionEffect(effect.getType());
	}

	@Override
	public IEntity launchEntity(RunsafeEntityType launchEntity)
	{
		Vector velocity = entity.getEyeLocation().getDirection().multiply(2);
		Entity launched = entity.getWorld().spawn(entity.getEyeLocation().add(velocity), launchEntity.getEntityType());
		launched.setVelocity(velocity);

		IEntity launchedEntity = ObjectWrapper.convert(launched);

		// ToDo: Refactor this later when we have a projectile API in place.
		if (launchedEntity instanceof BukkitProjectile)
			((BukkitProjectile) launchedEntity).setShooter(this);

		return launchedEntity;
	}

	@Override
	public void damage(double amount)
	{
		entity.damage(amount);
	}

	@Override
	public void damage(double amount, IEntity source)
	{
		entity.damage(amount, (Entity) ObjectUnwrapper.convert(source));
	}

	@Override
	public double getHealth()
	{
		return entity.getHealth();
	}

	@Override
	public double getMaxHealth()
	{
		return entity.getMaxHealth();
	}

	@Override
	public void resetMaxHealth()
	{
		entity.resetMaxHealth();
	}

	@Override
	public void setHealth(double amount)
	{
		entity.setHealth(amount);
	}

	@Override
	public void setMaxHealth(double amount)
	{
		entity.setMaxHealth(amount);
	}

	private final LivingEntity entity;
}
