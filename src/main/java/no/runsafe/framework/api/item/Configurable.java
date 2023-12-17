package no.runsafe.framework.api.item;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class Configurable
{
	private Configurable(){}

	@Nullable
	public static IMaterial getMaterial(String identifier)
	{
		String material = identifier.toLowerCase();
		if (materials.containsKey(material))
			return materials.get(material);
		return null;
	}

	// Register materials without data
	static void addSimple(IMaterial... values)
	{
		for (IMaterial material : values)
			materials.put(material.getName(), material);
	}

	private static final Map<String, IMaterial> materials = new ConcurrentHashMap<String, IMaterial>();
	static final char ID_SEPARATOR = ':';

	static
	{
		BuildingBlock.register();
		CobbleWall.register();
		Plank.register();
		Quartz.register();
		Sandstone.register();
		StoneBrick.register();
		StoneSlab.register();
		Wood.register();
		WoodSlab.register();
		Wool.register();
	}
}
