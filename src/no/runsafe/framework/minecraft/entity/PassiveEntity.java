package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.entity.IEntity;
import no.runsafe.framework.api.minecraft.RunsafeEntityType;
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
	StorageMinecart(EntityType.MINECART_CHEST),
	PoweredMinecart(EntityType.MINECART_FURNACE),
	HopperMinecart(EntityType.MINECART_HOPPER),
	SpawnerMinecart(EntityType.MINECART_MOB_SPAWNER),
	TNTMinecart(EntityType.MINECART_TNT),
	CommandMinecart(EntityType.MINECART_COMMAND),
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
}
