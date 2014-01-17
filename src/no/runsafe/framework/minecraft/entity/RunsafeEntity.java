package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.chunk.IChunk;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.data.EntityEffect;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageEvent;
import no.runsafe.framework.minecraft.metadata.RunsafeMetadata;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class RunsafeEntity extends RunsafeMetadata implements IEntity
{
	public RunsafeEntity(Entity toWrap)
	{
		super(toWrap);
		entity = toWrap;
	}

	@Override
	public boolean eject()
	{
		return entity.eject();
	}

	@Override
	public int getEntityId()
	{
		return entity.getEntityId();
	}

	@Override
	public float getFallDistance()
	{
		return entity.getFallDistance();
	}

	@Override
	public int getFireTicks()
	{
		return entity.getFireTicks();
	}

	@Override
	public RunsafeEntityDamageEvent getLastDamageCause()
	{
		return new RunsafeEntityDamageEvent(entity.getLastDamageCause());
	}

	@Nullable
	@Override
	public ILocation getLocation()
	{
		Location location = entity.getLocation();
		if (location == null)
			return null;

		return ObjectWrapper.convert(location);
	}

	@Override
	public int getMaxFireTicks()
	{
		return entity.getMaxFireTicks();
	}

	@Override
	public List<IEntity> getNearbyEntities(double x, double y, double z)
	{
		return ObjectWrapper.convert(entity.getNearbyEntities(x, y, z));
	}

	@Nullable
	@Override
	public IEntity getPassenger()
	{
		Entity passenger = entity.getPassenger();
		if (passenger == null)
			return null;

		return ObjectWrapper.convert(passenger);
	}

	@Override
	public IServer getServer()
	{
		return ObjectWrapper.convert(entity.getServer());
	}

	@Override
	public int getTicksLived()
	{
		return entity.getTicksLived();
	}

	@Override
	public RunsafeEntityType getEntityType()
	{
		return EntityType.convert(entity.getType());
	}

	@Override
	public UUID getUniqueId()
	{
		return entity.getUniqueId();
	}

	@Override
	public IEntity getVehicle()
	{
		return ObjectWrapper.convert(entity.getVehicle());
	}

	@Override
	public Vector getVelocity()
	{
		return entity.getVelocity();
	}

	@Nullable
	@Override
	public IWorld getWorld()
	{
		World world = entity.getWorld();
		if (world == null)
			return null;

		return ObjectWrapper.convert(world);
	}

	@Override
	public boolean isDead()
	{
		return entity.isDead();
	}

	@Override
	public boolean isEmpty()
	{
		return entity.isEmpty();
	}

	@Override
	public boolean isInsideVehicle()
	{
		return entity.isInsideVehicle();
	}

	@Override
	public boolean isOnGround()
	{
		return entity.isOnGround();
	}

	@Override
	public boolean isValid()
	{
		return entity.isValid();
	}

	@Override
	public boolean leaveVehicle()
	{
		return entity.leaveVehicle();
	}

	@Override
	public void playEffect(EntityEffect effect)
	{
		entity.playEffect(effect.toBukkit());
	}

	@Override
	public void remove()
	{
		entity.remove();
	}

	@Override
	public void setFallDistance(float distance)
	{
		entity.setFallDistance(distance);
	}

	@Override
	public void setFireTicks(int ticks)
	{
		entity.setFireTicks(ticks);
	}

	@Override
	public void setLastDamageCause(RunsafeEntityDamageEvent entityDamageEvent)
	{
		entity.setLastDamageCause(entityDamageEvent.getRaw());
	}

	@Override
	public boolean setPassenger(IEntity entity)
	{
		return this.entity.setPassenger((Entity) ObjectUnwrapper.convert(entity));
	}

	@Override
	public void setTicksLived(int ticks)
	{
		entity.setTicksLived(ticks);
	}

	@Override
	public void setVelocity(Vector velocity)
	{
		entity.setVelocity(velocity);
	}

	@Override
	public boolean teleport(ILocation location)
	{
		if (location == null)
			return false;

		IChunk targetChunk = location.getChunk();
		if (targetChunk.isUnloaded())
			targetChunk.load();

		if (isInsideVehicle()) // Dismount before teleporting.
			leaveVehicle();

		return entity.teleport((Location) ObjectUnwrapper.convert(location));
	}

	@Override
	public boolean teleport(IEntity targetEntity)
	{
		if (isInsideVehicle()) // Dismount before teleporting.
			leaveVehicle();

		return entity.teleport((Entity) ObjectUnwrapper.convert(targetEntity));
	}

	@Override
	public void strikeWithLightning(boolean effectOnly)
	{
		if (effectOnly)
			entity.getWorld().strikeLightningEffect(entity.getLocation());
		else
			entity.getWorld().strikeLightning(entity.getLocation());
	}

	@Override
	public void explode(float power, boolean setFire, boolean breakBlocks)
	{
		entity.getWorld().createExplosion(
			entity.getLocation().getBlockX(),
			entity.getLocation().getBlockY(),
			entity.getLocation().getBlockZ(),
			power,
			setFire,
			breakBlocks
		);
	}

	private final Entity entity;
}
