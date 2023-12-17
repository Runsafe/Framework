package no.runsafe.framework.api.minecraft;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.entity.IEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public interface RunsafeEntityType
{
	Class<? extends Entity> getEntityType();

	String getName();

	int getId();

	boolean isAlive();

	boolean isSpawnable();

	IEntity spawn(ILocation location);

	EntityType getRaw();

	String getAPIName();
}
