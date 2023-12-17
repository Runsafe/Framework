package no.runsafe.framework.api.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.metadata.IMetadata;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public interface IEntity extends IMetadata
{
	void strikeWithLightning(boolean effectOnly);
	void explode(float power, boolean setFire, boolean breakBlocks);
	@Nullable ILocation getLocation();
	@Nullable IWorld getWorld();
	boolean teleport(ILocation location);
	boolean teleport(IEntity entity);
	List<IEntity> getNearbyEntities(double x, double y, double z);
	int getEntityId();
	int getFireTicks();
	int getMaxFireTicks();
	void setFireTicks(int i);
	void remove();
	boolean isDead();
	@Nullable IEntity getPassenger();
	boolean setPassenger(IEntity entity);
	boolean isEmpty();
	boolean eject();
	float getFallDistance();
	void setFallDistance(float distance);
	void setLastDamageCause(RunsafeEntityDamageEvent entityDamageEvent);
	RunsafeEntityDamageEvent getLastDamageCause();
	UUID getUniqueId();
	int getTicksLived();
	void setTicksLived(int ticks);
	boolean isInsideVehicle();
	boolean leaveVehicle();
	IEntity getVehicle();
	RunsafeEntityType getEntityType();
	void setVelocity(Vector velocity);
	void setSilent(boolean audible);
	boolean isSilent();
	@Override boolean equals(Object o);
	@Override int hashCode();
}
