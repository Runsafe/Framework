package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.minecraft.RunsafeEntityType;
import no.runsafe.framework.minecraft.Item;
import org.bukkit.Material;

import javax.annotation.Nullable;
import java.util.EnumMap;
import java.util.Map;

public final class EntityType
{
	private EntityType()
	{
	}

	@SuppressWarnings("MethodWithMultipleLoops")
	@Nullable
	public static RunsafeEntityType convert(org.bukkit.entity.EntityType entityType)
	{
		if (types.isEmpty())
		{
			for (LivingEntity entity : LivingEntity.values())
				types.put(entity.getRaw(), entity);
			for (PassiveEntity entity : PassiveEntity.values())
				types.put(entity.getRaw(), entity);
			for (ProjectileEntity entity : ProjectileEntity.values())
				types.put(entity.getRaw(), entity);
		}
		if (!types.containsKey(entityType))
			return null;
		return types.get(entityType);
	}

	@Nullable
	public static RunsafeEntityType Get(Item item)
	{
		if (item.getType() != Material.MONSTER_EGG)
			return null;

		return Get(item.getData());
	}

	public static RunsafeEntityType Get(int id)
	{
		return convert(org.bukkit.entity.EntityType.fromId(id));
	}

	public static RunsafeEntityType Get(String name)
	{
		return convert(org.bukkit.entity.EntityType.valueOf(name));
	}

	private static final Map<org.bukkit.entity.EntityType, RunsafeEntityType> types =
		new EnumMap<org.bukkit.entity.EntityType, RunsafeEntityType>(org.bukkit.entity.EntityType.class);
}
