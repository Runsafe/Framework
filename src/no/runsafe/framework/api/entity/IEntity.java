package no.runsafe.framework.api.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.metadata.IMetadata;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
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
	void setFireTicks(int i);
	void remove();
	boolean isDead();
	void setPassenger(IEntity entity);
	boolean isEmpty();
	void eject();
	void setFallDistance(float distance);
	UUID getUniqueId();
	void leaveVehicle();
	IEntity getVehicle();
	RunsafeEntityType getEntityType();
	void setVelocity(Vector velocity);
	void setSilent(boolean audible);
	@Override boolean equals(Object o);
	@Override int hashCode();
}
