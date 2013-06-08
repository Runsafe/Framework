package no.runsafe.framework.wrapper.block;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.RunsafeWorld;
import no.runsafe.framework.server.block.RunsafeBlockState;
import no.runsafe.framework.server.material.RunsafeMaterial;
import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.wrapper.metadata.RunsafeMetadata;
import org.bukkit.Material;
import org.bukkit.block.Block;

public abstract class BukkitBlock extends RunsafeMetadata
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

	@SuppressWarnings("deprecation")
	@Deprecated
	public RunsafeMaterial getMaterialType()
	{
		return ObjectWrapper.convert(block.getType());
	}

	public void breakNaturally()
	{
		block.breakNaturally();
	}

	protected final Block block;
}
