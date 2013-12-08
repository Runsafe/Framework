package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.RunsafeWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public enum ProjectileEntity implements RunsafeEntityType
{
	Arrow(EntityType.ARROW),
	Egg(EntityType.EGG),
	EnderPearl(EntityType.ENDER_PEARL),
	Fireball(EntityType.FIREBALL),
	Firework(EntityType.FIREWORK),
	FishingHook(EntityType.FISHING_HOOK),
	PrimedTNT(EntityType.PRIMED_TNT),
	SmallFireball(EntityType.SMALL_FIREBALL),
	Snowball(EntityType.SNOWBALL),
	SplashPotion(EntityType.SPLASH_POTION),
	ThrownExperienceBottle(EntityType.THROWN_EXP_BOTTLE),
	WitherSkull(EntityType.WITHER_SKULL);

	ProjectileEntity(EntityType bukkitType)
	{
		type = bukkitType;
	}

	@Override
	public Class<? extends Entity> getEntityType()
	{
		return type.getEntityClass();
	}

	@Override
	public String getName()
	{
		return type.getName();
	}

	@Override
	public int getId()
	{
		return type.getTypeId();
	}

	@Override
	public boolean isAlive()
	{
		return type.isAlive();
	}

	@Override
	public boolean isSpawnable()
	{
		return type.isSpawnable();
	}

	@Override
	public EntityType getRaw()
	{
		return type;
	}

	@Override
	public RunsafeEntity spawn(ILocation location)
	{
		return ObjectWrapper.convert(((RunsafeWorld) location.getWorld()).spawn(location, type.getEntityClass()));
	}

	private final EntityType type;
}
