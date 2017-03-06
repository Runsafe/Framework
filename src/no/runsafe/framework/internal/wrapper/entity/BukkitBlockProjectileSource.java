package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.api.entity.IBlockProjectileSource;
import no.runsafe.framework.api.entity.IProjectileSource;
import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeProjectile;
import no.runsafe.framework.internal.extension.block.RunsafeDispenser;
import org.apache.commons.lang.Validate;
import org.bukkit.block.Dispenser;
import org.bukkit.util.Vector;
import org.bukkit.Material;

public abstract class BukkitBlockProjectileSource implements IBlockProjectileSource
{
    private final RunsafeDispenser dispenserBlock;

    public BukkitBlockProjectileSource(Dispenser toWrap)
    {
        dispenserBlock = ObjectWrapper.convert(toWrap);
    }

    public IBlock getBlock()
    {
        return this.dispenserBlock.getWorld().getBlockAt(
                this.dispenserBlock.getX(),
                this.dispenserBlock.getY(),
                this.dispenserBlock.getZ()
        );
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
