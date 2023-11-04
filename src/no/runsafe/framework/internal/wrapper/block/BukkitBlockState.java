package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.chunk.IChunk;
import no.runsafe.framework.internal.LegacyMaterial;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.internal.extension.block.RunsafeBlock;
import no.runsafe.framework.minecraft.material.RunsafeMaterialData;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

public class BukkitBlockState extends RunsafeBlock
{
	public BukkitBlockState(Block toWrap, BlockState state)
	{
		super(toWrap);
		blockState = state;
	}

	public IChunk getChunk()
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

	@Override
	public ILocation getLocation()
	{
		return ObjectWrapper.convert(blockState.getLocation());
	}

	@Override
	public Item getMaterial()
	{
		return Item.get(blockState.getType(), getData());
	}

	@Override
	public void setMaterial(Item material)
	{
		blockState.setType(material.getType());
	}

	@Deprecated
	public int getMaterialID()
	{
		return LegacyMaterial.getIdOf(blockState.getType());
	}

	@Override
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
