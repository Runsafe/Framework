package no.runsafe.framework.api.minecraft;

import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public interface RunsafeEntityType
{
	Class<? extends Entity> getEntityType();

	String getName();

	int getId();

	boolean isAlive();

	boolean isSpawnable();

	RunsafeEntity spawn(RunsafeLocation location);

	EntityType getRaw();
}
