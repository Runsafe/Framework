package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.api.entity.IBlockProjectileSource;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeBlockProjectileSource;
import no.runsafe.framework.minecraft.entity.RunsafeProjectile;
import no.runsafe.framework.internal.extension.block.RunsafeDispenser;
import org.bukkit.projectiles.BlockProjectileSource;
import org.bukkit.util.Vector;

public abstract class BukkitBlockProjectileSource implements IBlockProjectileSource
{
    private final BlockProjectileSource blockProjectileSource;

    public BukkitBlockProjectileSource(BlockProjectileSource toWrap)
    {
        blockProjectileSource = toWrap;
    }

    public IBlock getBlock()
    {
        return ObjectWrapper.convert(blockProjectileSource.getBlock());
    }

    public <T extends RunsafeProjectile> T launchProjectile(Class<? extends T> projectile)
    {
        return this.launchProjectile(projectile, (Vector)null);
    }

    public <T extends RunsafeProjectile> T launchProjectile(Class<? extends T> projectile, Vector velocity)
    {
        return this.launchProjectile(projectile, velocity);
    }

}
