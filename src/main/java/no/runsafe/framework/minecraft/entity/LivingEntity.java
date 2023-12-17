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
	Donkey(EntityType.DONKEY),
	ElderGuardian(EntityType.ELDER_GUARDIAN),
	Evoker(EntityType.EVOKER),
	EvokerFangs(EntityType.EVOKER_FANGS),
	EnderDragon(EntityType.ENDER_DRAGON),
	Enderman(EntityType.ENDERMAN),
	Endermite(EntityType.ENDERMITE),
	Ghast(EntityType.GHAST),
	Giant(EntityType.GIANT),
	Guardian(EntityType.GUARDIAN),
	Horse(EntityType.HORSE),
	Husk(EntityType.HUSK),
	Illusioner(EntityType.ILLUSIONER),
	IronGolem(EntityType.IRON_GOLEM),
	LavaSlime(EntityType.MAGMA_CUBE),
	Llama(EntityType.LLAMA),
	Mule(EntityType.MULE),
	MushroomCow(EntityType.MUSHROOM_COW),
	Ocelot(EntityType.OCELOT, "Ocelot"),
	Parrot(EntityType.PARROT),
	Pig(EntityType.PIG),
	PigZombie(EntityType.PIG_ZOMBIE, "PigZombie"),
	Player(EntityType.PLAYER),
	PolarBear(EntityType.POLAR_BEAR),
	Rabbit(EntityType.RABBIT),
	Sheep(EntityType.SHEEP),
	Shulker(EntityType.SHULKER),
	Silverfish(EntityType.SILVERFISH),
	Skeleton(EntityType.SKELETON),
	SkeletonHorse(EntityType.SKELETON_HORSE),
	Slime(EntityType.SLIME),
	Snowman(EntityType.SNOWMAN),
	Spider(EntityType.SPIDER),
	Squid(EntityType.SQUID),
	Stray(EntityType.STRAY),
	Vex(EntityType.VEX),
	Villager(EntityType.VILLAGER),
	Vindicator(EntityType.VINDICATOR),
	Witch(EntityType.WITCH),
	Wither(EntityType.WITHER),
	WitherSkeleton(EntityType.WITHER_SKELETON),
	Wolf(EntityType.WOLF),
	Zombie(EntityType.ZOMBIE),
	ZombieHorse(EntityType.ZOMBIE_HORSE),
	ZombieVillager(EntityType.ZOMBIE_VILLAGER);

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

	@Override
	public IEntity spawn(ILocation location)
	{
		return location.getWorld().spawn(location, this);
	}

	private final EntityType type;
	@Nullable
	private final String nameOverride;
}
