package no.runsafe.framework.minecraft.data;

public enum TreeSpecies
{
	BIRCH(org.bukkit.TreeSpecies.BIRCH),
	GENERIC(org.bukkit.TreeSpecies.GENERIC),
	JUNGLE(org.bukkit.TreeSpecies.JUNGLE),
	REDWOOD(org.bukkit.TreeSpecies.REDWOOD),
	ACACIA(org.bukkit.TreeSpecies.ACACIA),
	DARK_OAK(org.bukkit.TreeSpecies.DARK_OAK);

	TreeSpecies(org.bukkit.TreeSpecies bukkitType)
	{
		type = bukkitType;
	}

	public org.bukkit.TreeSpecies toBukkit()
	{
		return type;
	}

	public static TreeSpecies fromBukkit(org.bukkit.TreeSpecies bukkitType)
	{
		for (TreeSpecies treeSpecies : values())
			if (treeSpecies.toBukkit() == bukkitType)
				return treeSpecies;

		return GENERIC;
	}

	private final org.bukkit.TreeSpecies type;
}
