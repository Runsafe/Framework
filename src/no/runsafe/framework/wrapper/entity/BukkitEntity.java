package no.runsafe.framework.wrapper.entity;

import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.RunsafeServer;
import no.runsafe.framework.server.RunsafeWorld;
import no.runsafe.framework.server.entity.RunsafeEntity;
import no.runsafe.framework.server.entity.RunsafeEntityType;
import no.runsafe.framework.server.event.entity.RunsafeEntityDamageEvent;
import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.wrapper.metadata.RunsafeMetadata;
import org.bukkit.Chunk;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;

import java.util.List;
import java.util.UUID;

public class BukkitEntity extends RunsafeMetadata
{
	public BukkitEntity(Entity toWrap)
	{
		super(toWrap);
		entity = toWrap;
	}

	public Entity getRaw()
	{
		return entity;
	}

	public RunsafeLocation getLocation()
	{
		if (entity == null)
			return null;
		return ObjectWrapper.convert(entity.getLocation());
	}

	public RunsafeWorld getWorld()
	{
		if (entity == null)
			return null;
		return ObjectWrapper.convert(entity.getWorld());
	}

	public boolean teleport(RunsafeLocation location)
	{
		Chunk targetChunk = location.getWorld().getRaw().getChunkAt(location.getRaw());
		if (!targetChunk.isLoaded())
			targetChunk.load();

		return entity.teleport(location.getRaw());
	}

	public boolean teleport(RunsafeEntity entity)
	{
		return this.entity.teleport(entity.getRaw());
	}

	public List<RunsafeEntity> getNearbyEntities(double x, double y, double z)
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
		entity.remove();
	}

	public boolean isDead()
	{
		return entity.isDead();
	}

	public RunsafeServer getServer()
	{
		return RunsafeServer.Instance;
	}

	public RunsafeEntity getPassenger()
	{
		if (entity == null)
			return null;
		return ObjectWrapper.convert(entity.getPassenger());
	}

	public boolean setPassenger(RunsafeEntity entity)
	{
		return this.entity.setPassenger(entity.getRaw());
	}

	public boolean isEmpty()
	{
		return entity.isEmpty();
	}

	public boolean eject()
	{
		return entity.eject();
	}

	public float getFallDistance()
	{
		return entity.getFallDistance();
	}

	public void setFallDistance(float v)
	{
		entity.setFallDistance(v);
	}

	public void setLastDamageCause(RunsafeEntityDamageEvent entityDamageEvent)
	{
		entity.setLastDamageCause(entityDamageEvent.getRaw());
	}

	public RunsafeEntityDamageEvent getLastDamageCause()
	{
		return new RunsafeEntityDamageEvent(entity.getLastDamageCause());
	}

	public UUID getUniqueId()
	{
		return entity.getUniqueId();
	}

	public int getTicksLived()
	{
		return entity.getTicksLived();
	}

	public void setTicksLived(int i)
	{
		entity.setTicksLived(i);
	}

	public boolean isInsideVehicle()
	{
		return entity.isInsideVehicle();
	}

	public boolean leaveVehicle()
	{
		return entity.leaveVehicle();
	}

	public RunsafeEntity getVehicle()
	{
		return ObjectWrapper.convert(entity.getVehicle());
	}

	public RunsafeEntityType getEntityType()
	{
		return no.runsafe.framework.server.entity.EntityType.convert(entity.getType());
	}

	protected final Entity entity;
}
