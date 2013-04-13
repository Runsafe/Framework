package no.runsafe.framework.server.entity;

import java.util.HashMap;
import java.util.Map;

public class EntityType
{
	public static RunsafeEntityType convert(org.bukkit.entity.EntityType entityType)
	{
		if (!types.containsKey(entityType))
			return null;
		return types.get(entityType);
	}

	final static Map<org.bukkit.entity.EntityType, RunsafeEntityType> types = new HashMap<org.bukkit.entity.EntityType, RunsafeEntityType>();
}
