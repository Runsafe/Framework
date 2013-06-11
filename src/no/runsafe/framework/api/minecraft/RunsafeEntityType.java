package no.runsafe.framework.api.minecraft;

import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
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
