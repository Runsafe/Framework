package no.runsafe.framework.server.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public enum LivingEntity implements RunsafeEntityType
{
	Bat(EntityType.BAT),
	Blaze(EntityType.BLAZE),
	CaveSpider(EntityType.CAVE_SPIDER),
	Chicken(EntityType.CHICKEN),
	Cow(EntityType.COW),
	Creeper(EntityType.CREEPER),
	EnderDragon(EntityType.ENDER_DRAGON),
	Enderman(EntityType.ENDERMAN),
	Ghast(EntityType.GHAST),
	Giant(EntityType.GIANT),
	IronGolem(EntityType.IRON_GOLEM),
	LavaSlime(EntityType.MAGMA_CUBE),
	MushroomCow(EntityType.MUSHROOM_COW),
	Ocelot(EntityType.OCELOT),
	Pig(EntityType.PIG),
	PigZombie(EntityType.PIG_ZOMBIE),
	Player(EntityType.PLAYER),
	Sheep(EntityType.SHEEP),
	Silverfish(EntityType.SILVERFISH),
	Skeleton(EntityType.SKELETON),
	Slime(EntityType.SLIME),
	Snowman(EntityType.SNOWMAN),
	Spider(EntityType.SPIDER),
	Squid(EntityType.SQUID),
	Villager(EntityType.VILLAGER),
	Witch(EntityType.WITCH),
	Wither(EntityType.WITHER),
	Wolf(EntityType.WOLF),
	Zombie(EntityType.ZOMBIE);

	LivingEntity(EntityType bukkitType)
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
