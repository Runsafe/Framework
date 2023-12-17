package no.runsafe.framework.api.entity;

import no.runsafe.framework.api.minecraft.IAnimalTamer;

public interface ITameable
{
	boolean isTamed();
	void setTamed(boolean tamed);
	void setOwner(IAnimalTamer tamer);
	IAnimalTamer getOwner();
}
