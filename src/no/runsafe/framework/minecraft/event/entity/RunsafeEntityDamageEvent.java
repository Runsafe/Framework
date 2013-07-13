package no.runsafe.framework.minecraft.event.entity;

import no.runsafe.framework.api.event.CancellableEvent;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import org.bukkit.event.entity.EntityDamageEvent;

public class RunsafeEntityDamageEvent extends RunsafeEntityEvent implements CancellableEvent
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

	@Deprecated
	public void setDamage(int damage)
	{
		event.setDamage((double) damage);
	}

	public void setDamage(double damage)
	{
		event.setDamage(damage);
	}

	public RunsafeEntity getEntity()
	{
		return ObjectWrapper.convert(event.getEntity());
	}

	public RunsafeDamageCause getCause()
	{
		if (this.event == null)
			return RunsafeDamageCause.CUSTOM;

		return RunsafeDamageCause.valueOf(this.event.getCause().name());
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
