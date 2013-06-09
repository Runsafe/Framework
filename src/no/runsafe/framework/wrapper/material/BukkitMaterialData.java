package no.runsafe.framework.wrapper.material;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.server.item.meta.RunsafeMeta;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.material.MaterialData;

@SuppressWarnings("deprecation")
public abstract class BukkitMaterialData
{
	public BukkitMaterialData(MaterialData toWrap)
	{
		materialData = toWrap;
	}

	public MaterialData getRaw()
	{
		return materialData;
	}

	public Item getMaterial()
	{
		return Item.get(materialData);
	}

	public byte getData()
	{
		return this.materialData.getData();
	}

	public void setData(byte data)
	{
		this.materialData.setData(data);
	}

	public RunsafeMeta toItemStack()
	{
		return ObjectWrapper.convert(this.materialData.toItemStack());
	}

	public RunsafeMeta toItemStack(int amount)
	{
		return ObjectWrapper.convert(this.materialData.toItemStack(amount));
	}

	protected final MaterialData materialData;
}
