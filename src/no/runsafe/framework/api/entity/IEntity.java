package no.runsafe.framework.api.entity;

import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public interface IEntity
{
	void strikeWithLightning(boolean effectOnly);

	void explode(float power, boolean setFire, boolean breakBlocks);

	@Nullable
	RunsafeLocation getLocation();

	@Nullable
	RunsafeWorld getWorld();

	boolean teleport(RunsafeLocation location);

	boolean teleport(IEntity entity);

	List<IEntity> getNearbyEntities(double x, double y, double z);

	int getEntityId();

	int getFireTicks();

	int getMaxFireTicks();

	void setFireTicks(int i);

	void remove();

	boolean isDead();

	RunsafeServer getServer();

	@Nullable
	IEntity getPassenger();

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
}
