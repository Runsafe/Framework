package no.runsafe.framework.minecraft.event.entity;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.entity.RunsafeLivingEntity;
import no.runsafe.framework.api.event.CancellableEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class RunsafeEntitySpawnEvent extends RunsafeEntityEvent implements CancellableEvent
{
	public RunsafeEntitySpawnEvent(CreatureSpawnEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public boolean isFromMobSpawner()
	{
		return event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.SPAWNER);
	}

	public boolean isFromSpawnEgg()
	{
		return event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.SPAWNER_EGG);
	}

	public RunsafeLocation getLocation()
	{
		return ObjectWrapper.convert(event.getLocation());
	}

	public RunsafeLivingEntity getCreature()
	{
		return ObjectWrapper.convert(event.getEntity());
	}

	@Override
	public boolean getCancelled()
	{
		return event.isCancelled();
	}

	@Override
	public void setCancelled(boolean cancel)
	{
		event.setCancelled(cancel);
	}

	private final CreatureSpawnEvent event;
}
