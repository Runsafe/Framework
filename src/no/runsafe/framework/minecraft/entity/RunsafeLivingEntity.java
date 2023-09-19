package no.runsafe.framework.minecraft.entity;

import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.PathfinderGoal;
import net.minecraft.server.v1_8_R3.PathfinderGoalSelector;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.internal.LegacyMaterial;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.internal.wrapper.entity.BukkitLivingEntity;
import no.runsafe.framework.internal.wrapper.entity.BukkitProjectile;
import no.runsafe.framework.tools.reflection.ReflectionHelper;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R3.util.UnsafeList;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.HashSet;

public class RunsafeLivingEntity extends BukkitLivingEntity
{
	public static final int MAX_DISTANCE = 300;

	public RunsafeLivingEntity(LivingEntity toWrap)
	{
		super(toWrap);
	}

	@Override
	public IBlock getTargetBlock()
	{
		HashSet<Material> transparent = new HashSet<>(10);
		for (Material material : Material.values())
			if (material.isTransparent())
				transparent.add(material);

		return getTargetedBlock(transparent, MAX_DISTANCE);
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

	/**
	 * Removes all default path finding goals and targets.
	 */
	@Override
	public void stopPathfinding()
	{
		// Make sure this is an Insentient entity. Not all living entities are Insentient.
		EntityLiving rawLivingEntity = ((CraftLivingEntity) livingEntity).getHandle();
		if (!(rawLivingEntity instanceof EntityInsentient))
			return;
		EntityInsentient rawInsentientEntity = (EntityInsentient) rawLivingEntity;
		// Field name stays the same up to Minecraft 1.12.
		ReflectionHelper.setField(rawInsentientEntity.goalSelector, "b", new UnsafeList());
		ReflectionHelper.setField(rawInsentientEntity.targetSelector, "b", new UnsafeList());
	}

	/**
	 * Adds a new pathfinding goal.
	 * Reccomended to stop all pathfinding before using this to avoid problems with the goal number.
	 * @param priority
	 * @param goal The pathfinding goal to use.
	 */
	@Override
	public void setNewPathfindingGoal(int priority, PathfinderGoal goal)
	{
		// Make sure this is an Insentient entity. Not all living entities are Insentient.
		EntityLiving rawLivingEntity = ((CraftLivingEntity) livingEntity).getHandle();
		if (!(rawLivingEntity instanceof EntityInsentient))
			return;
		EntityInsentient rawInsentientEntity = (EntityInsentient) rawLivingEntity;
		rawInsentientEntity.goalSelector.a(priority, goal);
	}

	/**
	 * Adds a new pathfinding target.
	 * @param priority
	 * @param goal The pathfinding target to use.
	 */
	@Override
	public void setNewPathfindingTarget(int priority, PathfinderGoal target)
	{
		// Make sure this is an Insentient entity. Not all living entities are Insentient.
		EntityLiving rawLivingEntity = ((CraftLivingEntity) livingEntity).getHandle();
		if (!(rawLivingEntity instanceof EntityInsentient))
			return;
		EntityInsentient rawInsentientEntity = (EntityInsentient) rawLivingEntity;
		rawInsentientEntity.targetSelector.a(priority, target);
	}

	/**
	 * @return Whether or not this entity will naturally despawn.
	 */
	@Override
	public boolean getPersistance()
	{
		return livingEntity.getRemoveWhenFarAway();
	}

	/**
	 * @param persistance Whether or not this entity will naturally depsawn.
	 */
	@Override
	public void setPersistance(boolean persistance)
	{
		livingEntity.setRemoveWhenFarAway(persistance);
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

		RunsafeEntity projectileEntity = ObjectWrapper.convert(
			(Projectile) livingEntity.launchProjectile(projectile.asSubclass(Projectile.class))
		);

		if (projectileEntity instanceof Projectile)
			((Projectile) projectileEntity).setShooter(getRaw());

		return projectileEntity;
	}
}
