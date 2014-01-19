package no.runsafe.framework.minecraft.data;

public enum CoalType
{
	CHARCOAL(org.bukkit.CoalType.CHARCOAL),
	COAL(org.bukkit.CoalType.COAL);

	CoalType(org.bukkit.CoalType bukkitType)
	{
		type = bukkitType;
	}

	public org.bukkit.CoalType toBukkit()
	{
		return type;
	}

	public static CoalType fromBukkit(org.bukkit.CoalType bukkitType)
	{
		for (CoalType coalType : values())
			if (coalType.toBukkit() == bukkitType)
				return coalType;

		return COAL;
	}

	private final org.bukkit.CoalType type;
}
