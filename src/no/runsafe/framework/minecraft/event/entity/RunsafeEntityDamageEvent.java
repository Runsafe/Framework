package no.runsafe.framework.minecraft.event.entity;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import org.bukkit.event.entity.EntityDamageEvent;

public class RunsafeEntityDamageEvent extends RunsafeCancellableEntityEvent
{
	public RunsafeEntityDamageEvent(EntityDamageEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public double getDamage()
	{
		return event.getDamage();
	}

	public void setDamage(double damage)
	{
		event.setDamage(damage);
	}

	@Override
	public RunsafeEntity getEntity()
	{
		return ObjectWrapper.convert(event.getEntity());
	}

	public RunsafeDamageCause getCause()
	{
		if (event == null)
			return RunsafeDamageCause.CUSTOM;

		return RunsafeDamageCause.valueOf(event.getCause().name());
	}

	public EntityDamageEvent getRaw()
	{
		return event;
	}

	public enum RunsafeDamageCause
	{
		CONTACT,
		ENTITY_ATTACK,
		PROJECTILE,
		SUFFOCATION,
		FALL,
		FIRE,
		FIRE_TICK,
		MELTING,
		LAVA,
		DROWNING,
		BLOCK_EXPLOSION,
		ENTITY_EXPLOSION,
		VOID,
		LIGHTNING,
		SUICIDE,
		STARVATION,
		POISON,
		MAGIC,
		WITHER,
		FALLING_BLOCK,
		THORNS,
		CUSTOM
	}

	private final EntityDamageEvent event;
}
