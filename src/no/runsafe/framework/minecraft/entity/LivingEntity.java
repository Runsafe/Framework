package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import javax.annotation.Nullable;

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
	Endermite(EntityType.ENDERMITE),
	Ghast(EntityType.GHAST),
	Giant(EntityType.GIANT),
	Guardian(EntityType.GUARDIAN),
	Horse(EntityType.HORSE),
	IronGolem(EntityType.IRON_GOLEM),
	LavaSlime(EntityType.MAGMA_CUBE),
	MushroomCow(EntityType.MUSHROOM_COW),
	Ocelot(EntityType.OCELOT, "Ocelot"),
	Pig(EntityType.PIG),
	PigZombie(EntityType.PIG_ZOMBIE, "PigZombie"),
	Player(EntityType.PLAYER),
	Rabbit(EntityType.RABBIT),
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
		this(bukkitType, null);
	}

	LivingEntity(EntityType bukkitType, @Nullable String name)
	{
		type = bukkitType;
		nameOverride = name;
	}

	@Override
	public Class<? extends Entity> getEntityType()
	{
		return type.getEntityClass();
	}

	@Override
	public String getName()
	{
		return nameOverride == null ? type.getName() : nameOverride;
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
	public String getAPIName()
	{
		return name();
	}

	@SuppressWarnings("CastToConcreteClass")
	@Override
	public IEntity spawn(ILocation location)
	{
		return location.getWorld().spawn(location, this);
	}

	private final EntityType type;
	@Nullable
	private final String nameOverride;
}
