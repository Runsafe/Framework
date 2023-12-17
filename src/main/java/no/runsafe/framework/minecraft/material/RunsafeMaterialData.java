package no.runsafe.framework.minecraft.material;

import no.runsafe.framework.internal.wrapper.material.BukkitMaterialData;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

public class RunsafeMaterialData extends BukkitMaterialData
{
	public RunsafeMaterialData(MaterialData toWrap)
	{
		super(toWrap);
	}

	public RunsafeMaterialData(Material toWrap)
	{
		super(new MaterialData(toWrap));
	}

	@Deprecated
	public RunsafeMaterialData(int type)
	{
		super(new MaterialData(type));
	}

	@Deprecated
	public RunsafeMaterialData(int type, byte data)
	{
		super(new MaterialData(type, data));
	}
}