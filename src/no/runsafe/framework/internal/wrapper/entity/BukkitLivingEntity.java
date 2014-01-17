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
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

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
	public double getEyeHeight(boolean b)
	{
		return livingEntity.getEyeHeight(b);
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
	public void setRemainingAir(int i)
	{
		livingEntity.setRemainingAir(i);
	}

	@Override
	public int getMaximumAir()
	{
		return livingEntity.getMaximumAir();
	}

	@Override
	public void setMaximumAir(int i)
	{
		livingEntity.setMaximumAir(i);
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
	public void setMaximumNoDamageTicks(int i)
	{
		livingEntity.setMaximumNoDamageTicks(i);
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
	public void setNoDamageTicks(int i)
	{
		livingEntity.setNoDamageTicks(i);
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
	public void setLeashHolder(RunsafeEntity entity)
	{
		livingEntity.setLeashHolder(entity.getRaw());
	}

	protected final LivingEntity livingEntity;
}
