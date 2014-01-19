package no.runsafe.framework.minecraft.data;

import org.bukkit.material.CocoaPlant;

public enum CocoaPlantSize
{
	LARGE(CocoaPlant.CocoaPlantSize.LARGE),
	MEDIUM(CocoaPlant.CocoaPlantSize.MEDIUM),
	SMALL(CocoaPlant.CocoaPlantSize.SMALL);

	CocoaPlantSize(CocoaPlant.CocoaPlantSize bukkitType)
	{
		type = bukkitType;
	}

	public CocoaPlant.CocoaPlantSize toBukkit()
	{
		return type;
	}

	public static CocoaPlantSize fromBukkit(CocoaPlant.CocoaPlantSize bukkitType)
	{
		for (CocoaPlantSize size : values())
			if (size.toBukkit() == bukkitType)
				return size;

		return SMALL;
	}

	private final CocoaPlant.CocoaPlantSize type;
}
