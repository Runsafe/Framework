package no.runsafe.framework.minecraft.event.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.entity.RunsafeItem;
import org.bukkit.event.entity.EntityEvent;
import org.bukkit.event.entity.ItemSpawnEvent;

public class RunsafeItemSpawnEvent extends RunsafeCancellableEntityEvent
{
	public RunsafeItemSpawnEvent(ItemSpawnEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	@Override
	public RunsafeItem getEntity()
	{
		return ObjectWrapper.convert(event.getEntity());
	}

	public ILocation getLocation()
	{
		return ObjectWrapper.convert(event.getLocation());
	}

	private final ItemSpawnEvent event;
}
