package no.runsafe.framework.minecraft.data;

public enum DyeColor
{
	BLACK(org.bukkit.DyeColor.BLACK),
	BLUE(org.bukkit.DyeColor.BLUE),
	BROWN(org.bukkit.DyeColor.BROWN),
	CYAN(org.bukkit.DyeColor.CYAN),
	GRAY(org.bukkit.DyeColor.GRAY),
	GREEN(org.bukkit.DyeColor.GREEN),
	LIGHT_BLUE(org.bukkit.DyeColor.LIGHT_BLUE),
	LIME(org.bukkit.DyeColor.LIME),
	MAGENTA(org.bukkit.DyeColor.MAGENTA),
	ORANGE(org.bukkit.DyeColor.ORANGE),
	PINK(org.bukkit.DyeColor.PINK),
	PURPLE(org.bukkit.DyeColor.PURPLE),
	RED(org.bukkit.DyeColor.RED),
	SILVER(org.bukkit.DyeColor.SILVER),
	WHITE(org.bukkit.DyeColor.WHITE),
	YELLOW(org.bukkit.DyeColor.YELLOW);

	DyeColor(org.bukkit.DyeColor bukkitType)
	{
		type = bukkitType;
	}

	public org.bukkit.DyeColor toBukkit()
	{
		return type;
	}

	public static DyeColor fromBukkit(org.bukkit.DyeColor bukkitType)
	{
		for (DyeColor color : values())
			if (color.toBukkit() == bukkitType)
				return color;

		return WHITE;
	}

	private final org.bukkit.DyeColor type;
}
