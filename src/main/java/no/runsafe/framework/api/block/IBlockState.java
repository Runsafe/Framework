package no.runsafe.framework.api.block;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.chunk.IChunk;
import no.runsafe.framework.api.metadata.IMetadata;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.material.RunsafeMaterialData;

public interface IBlockState extends IMetadata
{
	IChunk getChunk();
	RunsafeMaterialData getMaterialData();
	byte getLightLevel();
	ILocation getLocation();
	Item getMaterial();
	void setMaterial(Item material);
	IWorld getWorld();
	void setMaterialData(RunsafeMaterialData materialData);
	void update(boolean forceUpdate);
}
