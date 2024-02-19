package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.entity.IAreaEffectCloud;
import no.runsafe.framework.internal.wrapper.entity.BukkitAreaEffectCloud;
import org.bukkit.entity.AreaEffectCloud;

public class RunsafeAreaEffectCloud extends BukkitAreaEffectCloud implements IAreaEffectCloud
{
    public RunsafeAreaEffectCloud(AreaEffectCloud toWrap)
    {
        super(toWrap);
    }
}