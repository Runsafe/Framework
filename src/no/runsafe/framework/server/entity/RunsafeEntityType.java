package no.runsafe.framework.server.entity;

import org.bukkit.entity.*;

public interface RunsafeEntityType
{
	public Class<? extends Entity> getEntityType();

	String getName();

	int getId();

	boolean isAlive();

	boolean isSpawnable();

	org.bukkit.entity.EntityType getRaw();
}
