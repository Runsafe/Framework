package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.block.RunsafeBlockState;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.internal.wrapper.metadata.BukkitMetadata;
import org.bukkit.block.Block;

public abstract class BukkitBlock extends BukkitMetadata
{
	public BukkitBlock(Block toWrap)
	{
		super(toWrap);
		block = toWrap;
	}

	public int getData()
	{
		return this.block.getData();
	}

	public void setData(byte data)
	{
		this.block.setData(data);
	}

	public void set(Item type)
	{
		block.setType(type.getType());
	}

	public int getTypeId()
	{
		return block.getTypeId();
	}

	public void setTypeId(int materialID)
	{
		this.block.setTypeId(materialID);
	}

	public RunsafeWorld getWorld()
	{
		return ObjectWrapper.convert(block.getWorld());
	}

	public RunsafeBlockState getBlockState()
	{
		return ObjectWrapper.convert(block.getState());
	}

	public RunsafeLocation getLocation()
	{
		return ObjectWrapper.convert(block.getLocation());
	}

	public Block getRaw()
	{
		return block;
	}

	public Item getMaterial()
	{
		return Item.get(block.getType(), block.getData());
	}

	public void setMaterial(Item material)
	{
		block.setType(material.getType());
		block.setData(material.getData());
	}

	public void breakNaturally()
	{
		block.breakNaturally();
	}

	protected final Block block;
}
