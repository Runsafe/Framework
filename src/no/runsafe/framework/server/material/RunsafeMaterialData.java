package no.runsafe.framework.server.material;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.material.MaterialData;

public class RunsafeMaterialData
{

    public RunsafeMaterialData(MaterialData toWrap)
    {
        materialData = toWrap;
    }

	public RunsafeMaterialData(int type)
	{
		this.materialData = new MaterialData(type);
	}

	public RunsafeMaterialData(RunsafeMaterial material)
	{
		this.materialData = new MaterialData(material.getRaw());
	}

	public RunsafeMaterialData(int type, byte data)
	{
		this.materialData = new MaterialData(type, data);
	}

	public RunsafeMaterialData(RunsafeMaterial material, byte data)
	{
		this.materialData = new MaterialData(material.getRaw(), data);
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

    private final MaterialData materialData;
}
