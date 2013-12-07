package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.minecraft.Buff;
import no.runsafe.framework.minecraft.inventory.RunsafeEntityEquipment;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.block.RunsafeBlock;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.LivingEntity;

import java.util.HashSet;
import java.util.List;

@SuppressWarnings("OverloadedMethodsWithSameNumberOfParameters")
public abstract class BukkitLivingEntity extends RunsafeEntity
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

	public double getHealth()
	{
		return livingEntity.getHealth();
	}

	@Deprecated
	public void setHealth(int i)
	{
		setHealth((double) i);
	}

	public void setHealth(double health)
	{
		if(livingEntity.getMaxHealth() < health)
			livingEntity.setHealth(livingEntity.getMaxHealth());
		else
			livingEntity.setHealth(health);
	}

	public RunsafeEntityEquipment getEquipment()
	{
		return ObjectWrapper.convert(livingEntity.getEquipment());
	}

	public double getMaxHealth()
	{
		return livingEntity.getMaxHealth();
	}

	public double getEyeHeight()
	{
		return livingEntity.getEyeHeight();
	}

	public double getEyeHeight(boolean b)
	{
		return livingEntity.getEyeHeight(b);
	}

	public RunsafeLocation getEyeLocation()
	{
		return ObjectWrapper.convert(livingEntity.getEyeLocation());
	}

	public List<IBlock> getLineOfSight(HashSet<Byte> transparent, int maxDistance)
	{
		return ObjectWrapper.convert(livingEntity.getLineOfSight(transparent, maxDistance));
	}

	public IBlock getTargetBlock(HashSet<Byte> transparent, int maxDistance)
	{
		return ObjectWrapper.convert(livingEntity.getTargetBlock(transparent, maxDistance));
	}

	public List<IBlock> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance)
	{
		return ObjectWrapper.convert(livingEntity.getLastTwoTargetBlocks(transparent, maxDistance));
	}

	public int getRemainingAir()
	{
		return livingEntity.getRemainingAir();
	}

	public void setRemainingAir(int i)
	{
		livingEntity.setRemainingAir(i);
	}

	public int getMaximumAir()
	{
		return livingEntity.getMaximumAir();
	}

	public void setMaximumAir(int i)
	{
		livingEntity.setMaximumAir(i);
	}

	@Deprecated
	public void damage(int i)
	{
		damage((double) i);
	}

	public void damage(double damage)
	{
		livingEntity.damage(damage);
	}

	public void damage(double damage, RunsafeEntity source)
	{
		livingEntity.damage(damage, source.getRaw());
	}

	@Deprecated
	public void damage(int damage, RunsafeEntity source)
	{
		damage((double) damage, source);
	}

	public int getMaximumNoDamageTicks()
	{
		return livingEntity.getMaximumNoDamageTicks();
	}

	public void setMaximumNoDamageTicks(int i)
	{
		livingEntity.setMaximumNoDamageTicks(i);
	}

	public double getLastDamage()
	{
		return livingEntity.getLastDamage();
	}

	@Deprecated
	public void setLastDamage(int i)
	{
		livingEntity.setLastDamage(i);
	}

	public void setLastDamage(double damage)
	{
		livingEntity.setLastDamage(damage);
	}

	public int getNoDamageTicks()
	{
		return livingEntity.getNoDamageTicks();
	}

	public void setNoDamageTicks(int i)
	{
		livingEntity.setNoDamageTicks(i);
	}

	public RunsafePlayer getKiller()
	{
		return ObjectWrapper.convert((OfflinePlayer) livingEntity.getKiller());
	}

	public void addBuff(Buff buff)
	{
		if (livingEntity != null)
			livingEntity.addPotionEffect(buff.getEffect());
	}

	public void removeBuff(Buff buff)
	{
		if (livingEntity != null)
			livingEntity.removePotionEffect(buff.getType());
	}

	protected final LivingEntity livingEntity;
}
