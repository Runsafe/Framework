package no.runsafe.framework.wrapper.entity;

import no.runsafe.framework.minecraft.Buff;
import no.runsafe.framework.server.RunsafeEntityEquipment;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.entity.RunsafeEntity;
import no.runsafe.framework.server.player.RunsafePlayer;
import no.runsafe.framework.server.potion.RunsafePotionEffect;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;

import java.util.HashSet;
import java.util.List;

public class BukkitLivingEntity extends RunsafeEntity
{
	public BukkitLivingEntity(LivingEntity toWrap)
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

	public RunsafeEntityEquipment getEquipment()
	{
		return ObjectWrapper.convert(this.entity.getEquipment());
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

	@Deprecated
	public boolean addPotionEffect(RunsafePotionEffect effect)
	{
		return this.entity.addPotionEffect(effect.getRaw());
	}

	@Deprecated
	public boolean addPotionEffect(RunsafePotionEffect effect, boolean force)
	{
		return this.entity.addPotionEffect(effect.getRaw(), force);
	}

	@Deprecated
	public void addPotionEffects(List<RunsafePotionEffect> effects)
	{
		for (RunsafePotionEffect effect : effects)
			this.entity.addPotionEffect(effect.getRaw());
	}

	@Deprecated
	public boolean hasPotionEffect(RunsafePotionEffect effect)
	{
		return this.entity.hasPotionEffect(effect.getRaw().getType());
	}

	@Deprecated
	public void removePotionEffect(RunsafePotionEffect effect)
	{
		this.entity.removePotionEffect(effect.getRaw().getType());
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
