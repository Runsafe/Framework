package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.entity.IBlockProjectileSource;
import no.runsafe.framework.internal.wrapper.entity.BukkitBlockProjectileSource;
import org.bukkit.projectiles.BlockProjectileSource;
import org.bukkit.block.Dispenser;

public class RunsafeBlockProjectileSource extends BukkitBlockProjectileSource implements IBlockProjectileSource
{
    public RunsafeBlockProjectileSource(BlockProjectileSource toWrap)
    {
        super((Dispenser)toWrap);
    }
}
