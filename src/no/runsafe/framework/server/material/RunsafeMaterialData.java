package no.runsafe.framework.server.material;

import org.bukkit.material.MaterialData;

public class RunsafeMaterialData
{

    public RunsafeMaterialData(MaterialData toWrap)
    {
        materialData = toWrap;
    }

    public MaterialData getRaw()
    {
        return materialData;
    }

    private MaterialData materialData;
}
