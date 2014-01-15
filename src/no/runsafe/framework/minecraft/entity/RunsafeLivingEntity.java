package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.entity.ILivingEntity;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.internal.LegacyMaterial;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.internal.wrapper.entity.BukkitLivingEntity;
import no.runsafe.framework.internal.wrapper.entity.BukkitProjectile;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;
import java.util.HashSet;

public class RunsafeLivingEntity extends BukkitLivingEntity implements ILivingEntity
{
	public static final int MAX_DISTANCE = 300;

	public RunsafeLivingEntity(LivingEntity toWrap)
	{
		super(toWrap);
	}

	@Override
	public IBlock getTargetBlock()
	{
		HashSet<Byte> transparent = new HashSet<Byte>(10);
		for (Material material : Material.values())
			if (material.isTransparent())
				transparent.add((byte) (int) LegacyMaterial.getIdOf(material));

		return getTargetBlock(transparent, MAX_DISTANCE);
	}

	public RunsafeEntity Fire(String projectileType)
	{
		return Fire(EntityType.fromName(projectileType).getEntityClass());
	}

	@Override
	public RunsafeEntity Fire(ProjectileEntity projectileType)
	{
		return Fire(projectileType.getEntityType());
	}

	public RunsafeEntity Launch(String entityType)
	{
		return Launch(EntityType.fromName(entityType).getEntityClass());
	}

	@Override
	public RunsafeEntity Launch(RunsafeEntityType entityType)
	{
		return Launch(entityType.getEntityType());
	}

	@Override
	public void removeBuffs()
	{
		if (livingEntity != null)
			for (PotionEffect effect : livingEntity.getActivePotionEffects())
				livingEntity.removePotionEffect(effect.getType());
	}

	@SuppressWarnings({"CastToConcreteClass", "InstanceofInterfaces", "LocalVariableOfConcreteClass"})
	private RunsafeEntity Launch(Class<? extends Entity> launch)
	{
		Vector velocity = livingEntity.getEyeLocation().getDirection().multiply(2);
		Entity launched = entity.getWorld().spawn(livingEntity.getEyeLocation().add(velocity), launch);
		launched.setVelocity(velocity);

		RunsafeEntity launchedEntity = ObjectWrapper.convert(launched);

		if (launchedEntity instanceof BukkitProjectile)
			((BukkitProjectile) launchedEntity).setShooter(this);

		return launchedEntity;
	}

	@SuppressWarnings("LocalVariableOfConcreteClass")
	@Nullable
	private RunsafeEntity Fire(Class<? extends Entity> projectile)
	{
		if (!Projectile.class.isAssignableFrom(projectile))
			return null;

		RunsafeEntity projectileEntity = ObjectWrapper.convert(livingEntity.launchProjectile(projectile.asSubclass(Projectile.class)));

		if (projectileEntity instanceof Projectile)
			((Projectile) projectileEntity).setShooter(getRaw());

		return projectileEntity;
	}
}
