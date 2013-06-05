package no.runsafe.framework.server.entity;

import no.runsafe.framework.server.RunsafeLocation;
import org.bukkit.entity.Entity;

public interface RunsafeEntityType
{
	public Class<? extends Entity> getEntityType();

	String getName();

	int getId();

	boolean isAlive();

	boolean isSpawnable();

	RunsafeEntity spawn(RunsafeLocation location);

	org.bukkit.entity.EntityType getRaw();
}
