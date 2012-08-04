package no.runsafe.framework.server.entity;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.entity.LivingEntity;

import java.util.HashSet;
import java.util.List;

public class RunsafeLivingEntity extends RunsafeEntity
{
	public RunsafeLivingEntity(LivingEntity toWrap)
	{
		super(toWrap);
		this.entity = entity;
	}

	public int getHealth()
	{
		return entity.getHealth();
	}

	public void setHealth(int i)
	{
		entity.setHealth(i);
	}

	public int getMaxHealth()
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
		return new RunsafeLocation(entity.getEyeLocation());
	}

	public List<RunsafeBlock> getLineOfSight(HashSet<Byte> bytes, int i)
	{
		return ObjectWrapper.convert(entity.getLineOfSight(bytes, i));
	}

	public RunsafeBlock getTargetBlock(HashSet<Byte> bytes, int i)
	{
		return ObjectWrapper.convert(entity.getTargetBlock(bytes, i));
	}

	public List<RunsafeBlock> getLastTwoTargetBlocks(HashSet<Byte> bytes, int i)
	{
		return ObjectWrapper.convert(entity.getLastTwoTargetBlocks(bytes, i));
	}

	//public <T extends Projectile> T launchProjectile(Class<? extends T> aClass)
	//{
	//}

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
		entity.damage(i);
	}

	public void damage(int i, RunsafeEntity source)
	{
		entity.damage(i, source.getRaw());
	}

	public int getMaximumNoDamageTicks()
	{
		return entity.getMaximumNoDamageTicks();
	}

	public void setMaximumNoDamageTicks(int i)
	{
		entity.setMaximumNoDamageTicks(i);
	}

	public int getLastDamage()
	{
		return entity.getLastDamage();
	}

	public void setLastDamage(int i)
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

//	public boolean addPotionEffect(PotionEffect potionEffect)
//	{
//	}
//
//	public boolean addPotionEffect(PotionEffect potionEffect, boolean b)
//	{
//	}
//
//	public boolean addPotionEffects(Collection<PotionEffect> potionEffects)
//	{
//	}
//
//	public boolean hasPotionEffect(PotionEffectType potionEffectType)
//	{
//	}
//
//	public void removePotionEffect(PotionEffectType potionEffectType)
//	{
//	}
//
//	public Collection<PotionEffect> getActivePotionEffects()
//	{
//	}

	private LivingEntity entity;
}
