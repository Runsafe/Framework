package no.runsafe.framework.server.entity;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.HashMap;
import java.util.Map;

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
		no.runsafe.framework.server.entity.EntityType.types.put(bukkitType, this);
	}

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

	private final EntityType type;
}
