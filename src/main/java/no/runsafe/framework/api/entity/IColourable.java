package no.runsafe.framework.api.entity;

import no.runsafe.framework.minecraft.entityData.DyeColour;

public interface IColourable
{
	void setColour(DyeColour colour);

	DyeColour getColour();

	void setRandomColour();
}
