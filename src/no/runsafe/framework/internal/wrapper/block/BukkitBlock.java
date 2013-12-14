package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.internal.LegacyMaterial;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.internal.wrapper.metadata.BukkitMetadata;
import no.runsafe.framework.minecraft.Item;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class BukkitBlock extends BukkitMetadata
{
	protected BukkitBlock(Block toWrap)
	{
		super(toWrap);
		block = toWrap;
	}

	public byte getData()
	{
		return block.getData();
	}

	public void setData(byte data)
	{
		block.setData(data);
	}

//	@Deprecated
//	public IBlockState getBlockState()
//	{
//		return ObjectWrapper.convert(block.getState());
//	}

	@SuppressWarnings("InstanceMethodNamingConvention")
	public void set(Item type)
	{
		block.setType(type.getType());
	}

	public int getTypeId()
	{
		return LegacyMaterial.getIdOf(block.getType());
	}

	public void setTypeId(int materialID)
	{
		block.setType(LegacyMaterial.getById(materialID));
	}

	public IWorld getWorld()
	{
		return ObjectWrapper.convert(block.getWorld());
	}

	public ILocation getLocation()
	{
		return ObjectWrapper.convert(block.getLocation());
	}

	@Override
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
