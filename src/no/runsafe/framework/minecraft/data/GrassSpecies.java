package no.runsafe.framework.minecraft.data;

public enum GrassSpecies
{
	DEAD(org.bukkit.GrassSpecies.DEAD),
	FERN_LIKE(org.bukkit.GrassSpecies.FERN_LIKE),
	NORMAL(org.bukkit.GrassSpecies.NORMAL);

	GrassSpecies(org.bukkit.GrassSpecies bukkitType)
	{
		type = bukkitType;
	}

	public org.bukkit.GrassSpecies toBukkit()
	{
		return type;
	}

	public static GrassSpecies fromBukkit(org.bukkit.GrassSpecies bukkitType)
	{
		for (GrassSpecies grassSpecies : values())
			if (grassSpecies.toBukkit() == bukkitType)
				return grassSpecies;

		return NORMAL;
	}

	private final org.bukkit.GrassSpecies type;
}
