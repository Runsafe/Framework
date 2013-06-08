package no.runsafe.framework.server.material;

import no.runsafe.framework.wrapper.material.BukkitMaterialData;
import org.bukkit.material.MaterialData;

public class RunsafeMaterialData extends BukkitMaterialData
{
	public RunsafeMaterialData(MaterialData toWrap)
	{
		super(toWrap);
	}

	public RunsafeMaterialData(int type)
	{
		super(new MaterialData(type));
	}

	@Deprecated
	public RunsafeMaterialData(RunsafeMaterial material)
	{
		super(new MaterialData(material.getRaw()));
	}

	public RunsafeMaterialData(int type, byte data)
	{
		super(new MaterialData(type, data));
	}

	@Deprecated
	public RunsafeMaterialData(RunsafeMaterial material, byte data)
	{
		super(new MaterialData(material.getRaw(), data));
	}
}
