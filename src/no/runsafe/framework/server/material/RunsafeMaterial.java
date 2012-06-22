package no.runsafe.framework.server.material;

import org.bukkit.Material;

public class RunsafeMaterial
{
	public RunsafeMaterial(Material toWrap)
	{
		material = toWrap;
	}

	public int getMaterialId()
	{
		return material.getId();
	}

	public Material getRaw()
	{
		return material;
	}

	private final Material material;
}
