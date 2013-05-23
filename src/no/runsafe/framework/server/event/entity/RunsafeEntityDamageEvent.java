package no.runsafe.framework.server.event.entity;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.entity.RunsafeEntity;
import no.runsafe.framework.server.event.CancellableEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class RunsafeEntityDamageEvent extends RunsafeEntityEvent implements CancellableEvent
{
	public RunsafeEntityDamageEvent(EntityDamageEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public int getDamage()
	{
		return event.getDamage();
	}

	public void setDamage(int damage)
	{
		event.setDamage(damage);
	}

	public RunsafeEntity getEntity()
	{
		return ObjectWrapper.convert(event.getEntity());
	}

	public RunsafeDamageCause getCause()
	{
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
		CUSTOM
	}

	private final EntityDamageEvent event;
}
