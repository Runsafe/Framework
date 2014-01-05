package no.runsafe.framework.api.entity;

public interface ICreature extends ILivingEntity
{
	ILivingEntity getTarget();
	void setTarget(ILivingEntity target);
}
