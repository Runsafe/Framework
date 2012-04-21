package no.runsafe.framework.server.block;

import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.RunsafeWorld;
import no.runsafe.framework.server.chunk.RunsafeChunk;
import no.runsafe.framework.server.material.RunsafeMaterial;
import no.runsafe.framework.server.material.RunsafeMaterialData;
import org.bukkit.block.BlockState;

public class RunsafeBlockState
{
    public RunsafeBlockState(BlockState toWrap)
    {
        blockState = toWrap;
    }

    public RunsafeChunk getChunk()
    {
        return new RunsafeChunk(blockState.getChunk());
    }

    public RunsafeMaterialData getMaterialData()
    {
        return new RunsafeMaterialData(blockState.getData());
    }

    public byte getLightLevel()
    {
        return blockState.getLightLevel();
    }

    public RunsafeLocation getLocation()
    {
        return new RunsafeLocation(blockState.getLocation());
    }

    public RunsafeMaterial getMaterial()
    {
        return new RunsafeMaterial(blockState.getType());
    }

    public int getMaterialID()
    {
        return blockState.getTypeId();
    }

    public RunsafeWorld getWorld()
    {
        return new RunsafeWorld(blockState.getWorld());
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

    public void setMaterial(RunsafeMaterial material)
    {
        blockState.setType(material.getRaw());
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

    private BlockState blockState;
}
