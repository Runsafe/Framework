package no.runsafe.framework.api.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IServer;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.metadata.IMetadata;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.minecraft.data.EntityEffect;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public interface IEntity extends IMetadata
{
	boolean eject();
	int getEntityId();
	float getFallDistance();
	int getFireTicks();
	RunsafeEntityDamageEvent getLastDamageCause();
	@Nullable ILocation getLocation();
	int getMaxFireTicks();
	List<IEntity> getNearbyEntities(double x, double y, double z);
	@Nullable IEntity getPassenger();
	IServer getServer();
	int getTicksLived();
	RunsafeEntityType getEntityType();
	UUID getUniqueId();
	IEntity getVehicle();
	Vector getVelocity();
	@Nullable IWorld getWorld();
	boolean isDead();
	boolean isEmpty();
	boolean isInsideVehicle();
	boolean isOnGround();
	boolean isValid();
	boolean leaveVehicle();
	void playEffect(EntityEffect effect);
	void remove();
	void setFallDistance(float distance);
	void setFireTicks(int ticks);
	void setLastDamageCause(RunsafeEntityDamageEvent entityDamageEvent);
	boolean setPassenger(IEntity entity);
	void setTicksLived(int ticks);
	void setVelocity(Vector velocity);
	boolean teleport(ILocation location);
	boolean teleport(IEntity targetEntity);

	// Runsafe
	void strikeWithLightning(boolean effectOnly);
	void explode(float power, boolean setFire, boolean breakBlocks);
}
