package no.runsafe.framework.api.item;

import org.bukkit.Material;
import org.bukkit.material.MaterialData;

public interface IMaterialComparator
{
	boolean isSame(Material material, MaterialData data);
}
