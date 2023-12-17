package no.runsafe.framework.api.item;

import org.bukkit.Material;

public interface IMaterial extends IMaterialComparator
{
	Material getMaterial();
	String getName();
}
