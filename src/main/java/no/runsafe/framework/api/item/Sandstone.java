package no.runsafe.framework.api.item;

import org.bukkit.Material;
import org.bukkit.SandstoneType;
import org.bukkit.material.MaterialData;

public enum Sandstone implements IMaterialData
{
	Any(null),
	Normal(SandstoneType.CRACKED),
	Chiseled(SandstoneType.GLYPHED),
	Smooth(SandstoneType.SMOOTH);

	Sandstone(SandstoneType type)
	{
		variant = type;
	}

	@Override
	public Material getMaterial()
	{
		return Material.SANDSTONE;
	}

	@Override
	public MaterialData getData()
	{
		return new org.bukkit.material.Sandstone(variant);
	}

	@Override
	public boolean isSame(Material material, MaterialData data)
	{
		if (material != Material.SANDSTONE || !(data instanceof org.bukkit.material.Sandstone))
			return false;

		return variant == null || ((org.bukkit.material.Sandstone) data).getType() == variant;
	}

	@Override
	public String getName()
	{
		return "Sandstone" + (this == Normal ? "" : Configurable.ID_SEPARATOR + name());
	}

	private final SandstoneType variant;

	static void register()
	{
		Configurable.addSimple(values());
	}
}
