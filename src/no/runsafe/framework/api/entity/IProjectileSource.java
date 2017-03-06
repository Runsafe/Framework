package no.runsafe.framework.api.entity;

import no.runsafe.framework.minecraft.entity.RunsafeProjectile;
import org.bukkit.util.Vector;

public interface IProjectileSource
{
    <T extends RunsafeProjectile> T launchProjectile(Class<? extends T> projectile);
    <T extends RunsafeProjectile> T launchProjectile(Class<? extends T> projectile, Vector velocity);
}
