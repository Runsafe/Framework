package no.runsafe.framework.api.item;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.material.MaterialData;
import org.bukkit.material.WoodenStep;

public enum WoodSlab implements IMaterial, IMaterialData
{
	Any(null),
	Oak(TreeSpecies.GENERIC),
	Spruce(TreeSpecies.REDWOOD),
	Birch(TreeSpecies.BIRCH),
	Jungle(TreeSpecies.JUNGLE),
	DarkOak(TreeSpecies.DARK_OAK),
	Acacia(TreeSpecies.ACACIA);

	WoodSlab(TreeSpecies species)
	{
		variant = species;
	}

	@Override
	public Material getMaterial()
	{
		return Material.WOOD_STEP;
	}

	@Override
	public boolean isSame(Material material, MaterialData data)
	{
		if (material != Material.WOOD_STEP || !(data instanceof WoodenStep))
			return false;

		return variant == null || ((WoodenStep) data).getSpecies() == variant;
	}

	@Override
	public MaterialData getData()
	{
		return new WoodenStep(variant);
	}

	private final TreeSpecies variant;
}
