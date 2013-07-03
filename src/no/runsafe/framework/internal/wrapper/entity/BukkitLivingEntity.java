package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.minecraft.Buff;
import no.runsafe.framework.minecraft.inventory.RunsafeEntityEquipment;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.block.RunsafeBlock;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.entity.LivingEntity;

import java.util.HashSet;
import java.util.List;

public abstract class BukkitLivingEntity extends RunsafeEntity
{
	protected BukkitLivingEntity(LivingEntity toWrap)
	{
		super(toWrap);
		this.entity = toWrap;
	}

	@Override
	public LivingEntity getRaw()
	{
		return entity;
	}

	public double getHealth()
	{
		return entity.getHealth();
	}

	public void setHealth(int i)
	{
		this.setHealth((double) i);
	}

	public void setHealth(double i)
	{
		entity.setHealth(i);
	}

	public RunsafeEntityEquipment getEquipment()
	{
		return ObjectWrapper.convert(this.entity.getEquipment());
	}

	public double getMaxHealth()
	{
		return entity.getMaxHealth();
	}

	public double getEyeHeight()
	{
		return entity.getEyeHeight();
	}

	public double getEyeHeight(boolean b)
	{
		return entity.getEyeHeight(b);
	}

	public RunsafeLocation getEyeLocation()
	{
		return ObjectWrapper.convert(entity.getEyeLocation());
	}

	public List<RunsafeBlock> getLineOfSight(HashSet<Byte> transparent, int maxDistance)
	{
		return ObjectWrapper.convert(entity.getLineOfSight(transparent, maxDistance));
	}

	public RunsafeBlock getTargetBlock(HashSet<Byte> transparent, int maxDistance)
	{
		return ObjectWrapper.convert(entity.getTargetBlock(transparent, maxDistance));
	}

	public List<RunsafeBlock> getLastTwoTargetBlocks(HashSet<Byte> transparent, int maxDistance)
	{
		return ObjectWrapper.convert(entity.getLastTwoTargetBlocks(transparent, maxDistance));
	}

	public int getRemainingAir()
	{
		return entity.getRemainingAir();
	}

	public void setRemainingAir(int i)
	{
		entity.setRemainingAir(i);
	}

	public int getMaximumAir()
	{
		return entity.getMaximumAir();
	}

	public void setMaximumAir(int i)
	{
		entity.setMaximumAir(i);
	}

	public void damage(int i)
	{
		this.damage((double) i);
	}

	public void damage(double i)
	{
		entity.damage(i);
	}

	public void damage(double i, RunsafeEntity source)
	{
		entity.damage(i, source.getRaw());
	}

	public void damage(int i, RunsafeEntity source)
	{
		this.damage((double) i, source);
	}

	public int getMaximumNoDamageTicks()
	{
		return entity.getMaximumNoDamageTicks();
	}

	public void setMaximumNoDamageTicks(int i)
	{
		entity.setMaximumNoDamageTicks(i);
	}

	public double getLastDamage()
	{
		return entity.getLastDamage();
	}

	public void setLastDamage(int i)
	{
		entity.setLastDamage((double) i);
	}

	public void setLastDamage(double i)
	{
		entity.setLastDamage(i);
	}

	public int getNoDamageTicks()
	{
		return entity.getNoDamageTicks();
	}

	public void setNoDamageTicks(int i)
	{
		entity.setNoDamageTicks(i);
	}

	public RunsafePlayer getKiller()
	{
		return ObjectWrapper.convert(entity.getKiller());
	}

	public void addBuff(Buff buff)
	{
		if (entity != null)
			entity.addPotionEffect(buff.getEffect());
	}

	public void removeBuff(Buff buff)
	{
		if (entity != null)
			entity.removePotionEffect(buff.getType());
	}

	protected final LivingEntity entity;
}
