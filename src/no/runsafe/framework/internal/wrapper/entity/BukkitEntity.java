package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.chunk.IChunk;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.internal.wrapper.metadata.BukkitMetadata;
import no.runsafe.framework.minecraft.entity.EntityType;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageByEntityEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageEvent;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public abstract class BukkitEntity extends BukkitMetadata
{
	protected BukkitEntity(Entity toWrap)
	{
		super(toWrap);
		entity = toWrap;
	}

	@Override
	public Entity getRaw()
	{
		return entity;
	}

	@Nullable
	public ILocation getLocation()
	{
		if (entity == null)
			return null;
		return ObjectWrapper.convert(entity.getLocation());
	}

	@Nullable
	public IWorld getWorld()
	{
		if (entity == null)
			return null;
		return ObjectWrapper.convert(entity.getWorld());
	}

	public boolean teleport(ILocation location)
	{
		if (location == null)
			return false;

		IChunk targetChunk = location.getChunk();
		if (targetChunk.isUnloaded())
			targetChunk.load();

		dismountBeforeTeleport();
		return entity.teleport((Location) ObjectUnwrapper.convert(location));
	}

	public boolean teleport(IEntity entity)
	{
		dismountBeforeTeleport();
		return this.entity.teleport((Entity) ObjectUnwrapper.convert(entity));
	}

	public List<IEntity> getNearbyEntities(double x, double y, double z)
	{
		return ObjectWrapper.convert(entity.getNearbyEntities(x, y, z));
	}

	public int getEntityId()
	{
		return entity.getEntityId();
	}

	public int getFireTicks()
	{
		return entity.getFireTicks();
	}

	public int getMaxFireTicks()
	{
		return entity.getMaxFireTicks();
	}

	public void setFireTicks(int i)
	{
		entity.setFireTicks(i);
	}

	public void remove()
	{
		if (entity != null)
			entity.remove();
	}

	public boolean isDead()
	{
		return entity != null && entity.isDead();
	}

	@Nullable
	public IEntity getPassenger()
	{
		if (entity == null)
			return null;
		return ObjectWrapper.convert(entity.getPassenger());
	}

	public boolean setPassenger(IEntity entity)
	{
		return this.entity.setPassenger((Entity) ObjectUnwrapper.convert(entity));
	}

	/**
	 * Checks if this entity has a passenger.
	 * @return True if there isn't a passenger.
	 */
	public boolean isEmpty()
	{
		return entity.isEmpty();
	}

	/**
	 * If there is an entity riding this entity, eject them.
	 * @return True if passenger was ejected, false otherwise.
	 */
	public boolean eject()
	{
		return entity.eject();
	}

	public float getFallDistance()
	{
		return entity.getFallDistance();
	}

	public void setFallDistance(float distance)
	{
		entity.setFallDistance(distance);
	}

	public void setLastDamageCause(RunsafeEntityDamageEvent entityDamageEvent)
	{
		entity.setLastDamageCause(entityDamageEvent.getRaw());
	}

	public RunsafeEntityDamageEvent getLastDamageCause()
	{
		EntityDamageEvent event = entity.getLastDamageCause();

		if (event instanceof EntityDamageByEntityEvent)
			return new RunsafeEntityDamageByEntityEvent((EntityDamageByEntityEvent) event);

		return new RunsafeEntityDamageEvent(entity.getLastDamageCause());
	}

	public UUID getUniqueId()
	{
		if (entity == null)
			return null;

		return entity.getUniqueId();
	}

	public int getTicksLived()
	{
		return entity.getTicksLived();
	}

	public void setTicksLived(int ticks)
	{
		entity.setTicksLived(ticks);
	}

	/**
	 * Checks if this entity is riding something.
	 * @return True if riding an entity, false otherwise.
	 */
	public boolean isInsideVehicle()
	{
		return entity.isInsideVehicle();
	}

	/**
	 * Dismounts whatever is being ridden.
	 * @return True if dismounted, false if not riding anything.
	 */
	public boolean leaveVehicle()
	{
		return entity.leaveVehicle();
	}

	public IEntity getVehicle()
	{
		return ObjectWrapper.convert(entity.getVehicle());
	}

	public RunsafeEntityType getEntityType()
	{
		return EntityType.convert(entity.getType());
	}

	public void setVelocity(Vector velocity)
	{
		entity.setVelocity(velocity);
	}

	private void dismountBeforeTeleport()
	{
		if (entity.getVehicle() != null)
			entity.getVehicle().eject();
	}

	public void setSilent(boolean audible)
	{
		/*
		 * Obfuscated method names in various spigot versions:
		 * v1_9_R2: c
		 * v1_10_R1 and up: setSilent
		 */
		((CraftEntity) entity).getHandle().b(audible);
	}

	public boolean isSilent()
	{
		/*
		 * Obfuscated method names in various spigot versions:
		 * v1_9_R2: ad
		 * v1_10_R1 and up: setSilent
		 */
		return ((CraftEntity) entity).getHandle().R();
	}

	/**
	 * Determines if two objects are the same entity.
	 * Uses UUIDs to compare objects.
	 * Can compare against runsafe and spigot entities.
	 * @param o Object to compare.
	 * @return True if and only if both objects have the same UUID.
	 */
	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;

		if(o == null)
			return false;

		if(o instanceof BukkitEntity)
			return this.getUniqueId().equals(((BukkitEntity) o).getUniqueId());

		if (o instanceof Entity)
			return this.getUniqueId().equals(((Entity) o).getUniqueId());

		return false;
	}

	@Override
	public int hashCode()
	{
		return getUniqueId().hashCode();
	}

	protected final Entity entity;
}
