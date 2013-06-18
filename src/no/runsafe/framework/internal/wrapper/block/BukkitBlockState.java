package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.chunk.RunsafeChunk;
import no.runsafe.framework.minecraft.material.RunsafeMaterialData;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.internal.wrapper.metadata.BukkitMetadata;
import org.bukkit.block.BlockState;

@SuppressWarnings("deprecation")
public abstract class BukkitBlockState extends BukkitMetadata
{
	protected BukkitBlockState(BlockState blockState)
	{
		super(blockState);
		this.blockState = blockState;
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

	public RunsafeLocation getLocation()
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
		return blockState.getTypeId();
	}

	public RunsafeWorld getWorld()
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
		blockState.setTypeId(materialId);
	}

	public void update(boolean forceUpdate)
	{
		blockState.update(forceUpdate);
	}

	public void update()
	{
		blockState.update();
	}

	public BlockState getRaw()
	{
		return blockState;
	}

	protected final BlockState blockState;
}
