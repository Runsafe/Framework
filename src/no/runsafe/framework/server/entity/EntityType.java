package no.runsafe.framework.server.entity;

import java.util.HashMap;
import java.util.Map;

public class EntityType
{
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

	private final static Map<org.bukkit.entity.EntityType, RunsafeEntityType> types = new HashMap<org.bukkit.entity.EntityType, RunsafeEntityType>();
}
