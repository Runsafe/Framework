package no.runsafe.framework.server.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

public enum PassiveEntity implements RunsafeEntityType
{
	Boat(EntityType.BOAT),
	DroppedItem(EntityType.DROPPED_ITEM),
	EnderCrystal(EntityType.ENDER_CRYSTAL),
	EnderSignal(EntityType.ENDER_SIGNAL),
	ExperienceOrb(EntityType.EXPERIENCE_ORB),
	FallingBlock(EntityType.FALLING_BLOCK),
	ItemFrame(EntityType.ITEM_FRAME),
	Lightning(EntityType.LIGHTNING),
	Minecart(EntityType.MINECART),
	Painting(EntityType.PAINTING),
	Unknown(EntityType.UNKNOWN),
	Weather(EntityType.WEATHER);

	PassiveEntity(EntityType bukkitType)
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
