package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.internal.LegacyMaterial;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.block.RunsafeBlock;
import no.runsafe.framework.minecraft.chunk.RunsafeChunk;
import no.runsafe.framework.minecraft.material.RunsafeMaterialData;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

public abstract class BukkitBlockState extends RunsafeBlock
{
	protected BukkitBlockState(Block toWrap, BlockState state)
	{
		super(toWrap);
		blockState = state;
	}

	public RunsafeChunk getChunk()
	{
		return ObjectWrapper.convert(blockState.getChunk());
	}

	public RunsafeMaterialData getMaterialData()
	{
		return ObjectWrapper.convert(blockState.getData());
	}

	public byte getLightLevel()
	{
		return blockState.getLightLevel();
	}

	public ILocation getLocation()
	{
		return ObjectWrapper.convert(blockState.getLocation());
	}

	public Item getMaterial()
	{
		return Item.get(blockState.getType(), (byte) 0);
	}

	public void setMaterial(Item material)
	{
		blockState.setType(material.getType());
	}

	public int getMaterialID()
	{
		return LegacyMaterial.getIdOf(blockState.getType());
	}

	public IWorld getWorld()
	{
		return ObjectWrapper.convert(blockState.getWorld());
	}

	public int getX()
	{
		return blockState.getX();
	}

	public int getY()
	{
		return blockState.getY();
	}

	public int getZ()
	{
		return blockState.getZ();
	}

	public void setMaterialData(RunsafeMaterialData materialData)
	{
		blockState.setData(materialData.getRaw());
	}

	public void setMaterialId(int materialId)
	{
		blockState.setType(LegacyMaterial.getById(materialId));
	}

	public void update(boolean forceUpdate)
	{
		blockState.update(forceUpdate);
	}

	public void update()
	{
		blockState.update();
	}

	protected final BlockState blockState;
}
