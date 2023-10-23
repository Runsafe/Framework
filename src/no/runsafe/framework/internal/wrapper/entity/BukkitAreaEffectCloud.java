package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.api.entity.IProjectileSource;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.WorldEffect;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Parrot;

public class BukkitAreaEffectCloud extends RunsafeEntity
{
    public BukkitAreaEffectCloud(AreaEffectCloud toWrap)
    {
        super(toWrap);
        cloud = toWrap;
    }

    public int getDuration()
    {
        return cloud.getDuration();
    }

    public void setDuration(int duration)
    {
        cloud.setDuration(duration);
    }

    public int getWaitTime()
    {
        return cloud.getWaitTime();
    }

    public void setWaitTime(int waitTime)
    {
        cloud.setWaitTime(waitTime);
    }

    public int getReapplicationDelay()
    {
        return cloud.getReapplicationDelay();
    }

    public void setReapplicationDelay(int delay)
    {
        cloud.setReapplicationDelay(delay);
    }

    public int getDurationOnUse()
    {
        return cloud.getDurationOnUse();
    }

    public void setDurationOnUse(int duration)
    {
        cloud.setDurationOnUse(duration);
    }

    public float getRadius()
    {
        return cloud.getRadius();
    }

    public void setRadius(float radius)
    {
        cloud.setRadius(radius);
    }

    public float getRadiusOnUse()
    {
        return cloud.getRadiusOnUse();
    }

    public void setRadiusOnUse(float radius)
    {
        cloud.setRadiusOnUse(radius);
    }

    public float getRadiusPerTick()
    {
        return cloud.getRadiusPerTick();
    }

    public void setRadiusPerTick(float radius)
    {
        cloud.setRadiusPerTick(radius);
    }

    public boolean hasCustomEffects()
    {
        return cloud.hasCustomEffects();
    }

    public void clearCustomEffects()
    {
        cloud.clearCustomEffects();
    }

    public IProjectileSource getSource()
    {
        return ObjectWrapper.convert(cloud.getSource());
    }

    public void setSource(IProjectileSource source)
    {
        cloud.setSource(ObjectUnwrapper.convert(source));
    }

    protected final AreaEffectCloud cloud;
}