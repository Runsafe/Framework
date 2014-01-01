package no.runsafe.framework.api.item;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.material.Colorable;
import org.bukkit.material.MaterialData;

public enum Wool implements IMaterialData
{
	Any(null),
	White(DyeColor.WHITE),
	Orange(DyeColor.ORANGE),
	Magenta(DyeColor.MAGENTA),
	LightBlue(DyeColor.LIGHT_BLUE),
	Yellow(DyeColor.YELLOW),
	Lime(DyeColor.LIME),
	Pink(DyeColor.PINK),
	Gray(DyeColor.GRAY),
	LightGray(DyeColor.GRAY),
	Cyan(DyeColor.CYAN),
	Purple(DyeColor.PURPLE),
	Blue(DyeColor.BLUE),
	Brown(DyeColor.BROWN),
	Green(DyeColor.GREEN),
	Red(DyeColor.RED),
	Black(DyeColor.BLACK);

	@Override
	public Material getMaterial()
	{
		return Material.WOOL;
	}

	@Override
	public boolean isSame(Material material, MaterialData data)
	{
		if (material != Material.WOOL || !(data instanceof org.bukkit.material.Wool))
			return false;

		return variant == null || ((Colorable) data).getColor() == variant;
	}

	@Override
	public MaterialData getData()
	{
		return new org.bukkit.material.Wool(variant);
	}

	@Override
	public String getName()
	{
		return "Wool" + (this == White ? "" : Configurable.ID_SEPARATOR + name());
	}

	Wool(DyeColor colour)
	{
		variant = colour;
	}

	private final DyeColor variant;

	static void register()
	{
		Configurable.addSimple(values());
	}
}
