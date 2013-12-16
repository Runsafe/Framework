package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.internal.wrapper.BukkitWorld;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
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

	@SuppressWarnings("CastToConcreteClass")
	@Override
	public RunsafeEntity spawn(ILocation location)
	{
		return ObjectWrapper.convert(((BukkitWorld) location.getWorld()).spawn(location, type.getEntityClass()));
	}

	private final EntityType type;
}
