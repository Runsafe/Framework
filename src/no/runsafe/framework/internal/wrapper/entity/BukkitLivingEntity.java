package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.entity.ILivingEntity;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.minecraft.Buff;
import no.runsafe.framework.minecraft.inventory.RunsafeEntityEquipment;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.entity.RunsafeProjectile;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

import java.util.HashSet;
import java.util.List;

public abstract class BukkitLivingEntity extends RunsafeEntity implements ILivingEntity
{
	protected BukkitLivingEntity(LivingEntity toWrap)
	{
		super(toWrap);
		livingEntity = toWrap;
	}

	@Override
	public LivingEntity getRaw()
	{
		return livingEntity;
	}

	@Override
	public double getHealth()
	{
		return livingEntity.getHealth();
	}

	@Override
	public void setHealth(double health)
	{
		if(livingEntity.getMaxHealth() < health)
			livingEntity.setHealth(livingEntity.getMaxHealth());
		else
			livingEntity.setHealth(health);
	}

	@Override
	public RunsafeEntityEquipment getEquipment()
	{
		return ObjectWrapper.convert(livingEntity.getEquipment());
	}

	@Override
	public double getMaxHealth()
	{
		return livingEntity.getMaxHealth();
	}

	@Override
	public double getEyeHeight()
	{
		return livingEntity.getEyeHeight();
	}

	@Override
	public double getEyeHeight(boolean ignoreSneaking)
	{
		return livingEntity.getEyeHeight(ignoreSneaking);
	}

	@Override
	public ILocation getEyeLocation()
	{
		return ObjectWrapper.convert(livingEntity.getEyeLocation());
	}

	@Override
	public List<IBlock> getLineOfSight(HashSet<Byte> transparent, int maxDistance)
	{
		return ObjectWrapper.convert(livingEntity.getLineOfSight(transparent, maxDistance));
	}

	@Override
	public IBlock getTargetBlock(HashSet<Byte> transparent, int maxDistance)
	{
		return ObjectWrapper.convert(livingEntity.getTargetBlock(transparent, maxDistance));
	}

	@Override
	public List<IBlock> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance)
	{
		return ObjectWrapper.convert(livingEntity.getLastTwoTargetBlocks(transparent, maxDistance));
	}

	@Override
	public int getRemainingAir()
	{
		return livingEntity.getRemainingAir();
	}

	@Override
	public void setRemainingAir(int remainingAirTicks)
	{
		livingEntity.setRemainingAir(remainingAirTicks);
	}

	@Override
	public int getMaximumAir()
	{
		return livingEntity.getMaximumAir();
	}

	@Override
	public void setMaximumAir(int maximumAirTicks)
	{
		livingEntity.setMaximumAir(maximumAirTicks);
	}

	@Override
	public void damage(double damage)
	{
		livingEntity.damage(damage);
	}

	@Override
	public void damage(double damage, IEntity source)
	{
		livingEntity.damage(damage, (Entity)ObjectUnwrapper.convert(source));
	}

	@Override
	public int getMaximumNoDamageTicks()
	{
		return livingEntity.getMaximumNoDamageTicks();
	}

	@Override
	public void setMaximumNoDamageTicks(int maximumNoDamageTicks)
	{
		livingEntity.setMaximumNoDamageTicks(maximumNoDamageTicks);
	}

	@Override
	public double getLastDamage()
	{
		return livingEntity.getLastDamage();
	}

	@Override
	public void setLastDamage(double damage)
	{
		livingEntity.setLastDamage(damage);
	}
	@Override

	public int getNoDamageTicks()
	{
		return livingEntity.getNoDamageTicks();
	}

	@Override
	public void setNoDamageTicks(int noDamageTicks)
	{
		livingEntity.setNoDamageTicks(noDamageTicks);
	}

	@Override
	public IPlayer getKiller()
	{
		return ObjectWrapper.convert((OfflinePlayer) livingEntity.getKiller());
	}

	@Override
	public void addBuff(Buff buff)
	{
		if (livingEntity != null)
			livingEntity.addPotionEffect(buff.getEffect());
	}

	@Override
	public void removeBuff(Buff buff)
	{
		if (livingEntity != null)
			livingEntity.removePotionEffect(buff.getType());
	}

	@Override
	public IEntity getLeashHolder()
	{
		return ObjectWrapper.convert(livingEntity.getLeashHolder());
	}

	@Override
	public boolean isLeashed()
	{
		return livingEntity.isLeashed();
	}

	@Override
	public void setLeashHolder(RunsafeEntity entity)
	{
		livingEntity.setLeashHolder(entity.getRaw());
	}

	@Override
	public void setMaxHealth(double amount)
	{
		livingEntity.setMaxHealth(amount);
	}

	@Override
	public void resetMaxHealth()
	{
		livingEntity.resetMaxHealth();
	}

	@Override
	public void setCustomName(String name)
	{
		livingEntity.setCustomName(name);
	}

	@Override
	public String getCustomName()
	{
		return livingEntity.getCustomName();
	}

	public <T extends RunsafeProjectile> T launchProjectile(Class<? extends T> projectile)
	{
		return this.launchProjectile(projectile, (Vector)null);
	}

	public <T extends RunsafeProjectile> T launchProjectile(Class<? extends T> projectile, Vector velocity)
	{
		return this.launchProjectile(projectile, velocity);
	}

	protected final LivingEntity livingEntity;
}
