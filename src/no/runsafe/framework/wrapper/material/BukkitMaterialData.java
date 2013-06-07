package no.runsafe.framework.wrapper.material;

import no.runsafe.framework.server.item.RunsafeItemStack;
import no.runsafe.framework.server.material.RunsafeMaterial;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.material.MaterialData;

public class BukkitMaterialData
{
	public BukkitMaterialData(MaterialData toWrap)
	{
		materialData = toWrap;
	}

	public MaterialData getRaw()
	{
		return materialData;
	}

	public byte getData()
	{
		return this.materialData.getData();
	}

	public void setData(byte data)
	{
		this.materialData.setData(data);
	}

	public RunsafeMaterial getItemType()
	{
		return ObjectWrapper.convert(this.materialData.getItemType());
	}

	public int getItemTypeId()
	{
		return this.materialData.getItemTypeId();
	}

	public RunsafeItemStack toItemStack()
	{
		return ObjectWrapper.convert(this.materialData.toItemStack());
	}

	public RunsafeItemStack toItemStack(int amount)
	{
		return ObjectWrapper.convert(this.materialData.toItemStack(amount));
	}

	protected final MaterialData materialData;
}
