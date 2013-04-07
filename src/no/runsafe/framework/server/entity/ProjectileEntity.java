package no.runsafe.framework.server.entity;

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

	public Class<? extends Entity> getEntityType()
	{
		return type.getEntityClass();
	}

	public String getName()
	{
		return type.getName();
	}

	public int getId()
	{
		return type.getTypeId();
	}

	public boolean isAlive()
	{
		return type.isAlive();
	}

	public boolean isSpawnable()
	{
		return type.isSpawnable();
	}

	public EntityType getRaw()
	{
		return type;
	}

	private final EntityType type;
}
