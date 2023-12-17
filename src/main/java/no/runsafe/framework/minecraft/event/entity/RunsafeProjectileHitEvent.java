package no.runsafe.framework.minecraft.event.entity;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeProjectile;
import org.bukkit.event.entity.ProjectileHitEvent;

public class RunsafeProjectileHitEvent extends RunsafeEntityEvent
{
	public RunsafeProjectileHitEvent(ProjectileHitEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeProjectile getProjectile()
	{
		return ObjectWrapper.convert(event.getEntity());
	}

	private final ProjectileHitEvent event;
}
