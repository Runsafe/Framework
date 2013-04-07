package no.runsafe.framework.server.entity;

import org.bukkit.entity.Entity;

public interface RunsafeEntityType
{
	public Class<? extends Entity> getEntityType();
}
