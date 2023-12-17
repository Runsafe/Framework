package no.runsafe.framework.api.item;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Tree;

public enum Plank implements IMaterialData
{
	Any(null),
	Oak(TreeSpecies.GENERIC),
	Spruce(TreeSpecies.REDWOOD),
	Birch(TreeSpecies.BIRCH),
	Jungle(TreeSpecies.JUNGLE),
	DarkOak(TreeSpecies.DARK_OAK),
	Acacia(TreeSpecies.ACACIA);

	Plank(TreeSpecies species)
	{
		variant = species;
	}

	@Override
	public Material getMaterial()
	{
		return Material.WOOD;
	}

	@Override
	public boolean isSame(Material material, MaterialData data)
	{
		if (material != Material.WOOD || !(data instanceof Tree))
			return false;

		return variant == null || ((Tree) data).getSpecies() == variant;
	}

	@Override
	public MaterialData getData()
	{
		return new Tree(variant);
	}

	@Override
	public String getName()
	{
		return "Plank" + (this == Oak ? "" : Configurable.ID_SEPARATOR + name());
	}

	private final TreeSpecies variant;

	static void register()
	{
		Configurable.addSimple(values());
	}
}
