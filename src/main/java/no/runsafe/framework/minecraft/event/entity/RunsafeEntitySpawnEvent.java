package no.runsafe.framework.minecraft.event.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeLivingEntity;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class RunsafeEntitySpawnEvent extends RunsafeCancellableEntityEvent
{
	public RunsafeEntitySpawnEvent(CreatureSpawnEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public boolean isFromMobSpawner()
	{
		return event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER;
	}

	public boolean isFromSpawnEgg()
	{
		return event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER_EGG;
	}

	public ILocation getLocation()
	{
		return ObjectWrapper.convert(event.getLocation());
	}

	public RunsafeLivingEntity getCreature()
	{
		return ObjectWrapper.convert(event.getEntity());
	}

	private final CreatureSpawnEvent event;
}
