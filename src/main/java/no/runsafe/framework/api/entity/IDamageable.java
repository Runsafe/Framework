package no.runsafe.framework.api.entity;

public interface IDamageable extends IEntity
{
	void damage(double amount);
	void damage(double amount, IEntity source);
	double getHealth();
	double getMaxHealth();
	void resetMaxHealth();
	void setHealth(double amount);
	void setMaxHealth(double amount);
}
