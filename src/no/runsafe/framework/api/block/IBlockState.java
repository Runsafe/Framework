package no.runsafe.framework.api.block;

import no.runsafe.framework.api.metadata.IMetadata;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeWorld;
import no.runsafe.framework.minecraft.chunk.RunsafeChunk;
import no.runsafe.framework.minecraft.material.RunsafeMaterialData;

public interface IBlockState extends IMetadata
{
	RunsafeChunk getChunk();
	RunsafeMaterialData getMaterialData();
	byte getLightLevel();
	RunsafeLocation getLocation();
	Item getMaterial();
	void setMaterial(Item material);
	RunsafeWorld getWorld();
	void setMaterialData(RunsafeMaterialData materialData);
	void update(boolean forceUpdate);
}
