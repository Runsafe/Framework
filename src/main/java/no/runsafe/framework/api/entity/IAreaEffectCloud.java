package no.runsafe.framework.api.entity;

public interface IAreaEffectCloud extends IEntity
{
    int getDuration();
    void setDuration(int duration);
    int getWaitTime();
    void setWaitTime(int waitTime);
    int getReapplicationDelay();
    void setReapplicationDelay(int delay);
    int getDurationOnUse();
    void setDurationOnUse(int duration);
    float getRadius();
    void setRadius(float radius);
    float getRadiusOnUse();
    void setRadiusOnUse(float radius);
    float getRadiusPerTick();
    void setRadiusPerTick(float radius);
    boolean hasCustomEffects();
    void clearCustomEffects();
    IProjectileSource getSource();
    void setSource(IProjectileSource source);
}