package no.runsafe.framework.server.entity;

import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.server.RunsafeLocation;
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
	public RunsafeEntity spawn(RunsafeLocation location)
	{
		return ObjectWrapper.convert(location.getWorld().spawn(location, type.getEntityClass()));
	}

	private final EntityType type;
}
