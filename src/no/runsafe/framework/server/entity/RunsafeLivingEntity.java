package no.runsafe.framework.server.entity;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.util.Vector;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RunsafeLivingEntity extends RunsafeEntity
{
	public RunsafeLivingEntity(LivingEntity toWrap)
	{
		super(toWrap);
		this.entity = toWrap;
	}

	public LivingEntity getRaw()
	{
		return entity;
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
		return ObjectWrapper.convert(entity.getEyeLocation());
	}

	public RunsafeBlock getTarget()
	{
		HashSet<Byte> transparent = new HashSet<Byte>();
		for(Material material : Material.values())
			if(material.isTransparent())
				transparent.add((byte) material.getId());
		return getTargetBlock(transparent, 300);
	}

	public void Fire(String projectileType)
	{
		Class<? extends Entity> projectile = EntityType.fromName(projectileType).getEntityClass();
		if(Projectile.class.isAssignableFrom(projectile))
			entity.launchProjectile(projectile.asSubclass(Projectile.class));
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

	private final LivingEntity entity;
}
