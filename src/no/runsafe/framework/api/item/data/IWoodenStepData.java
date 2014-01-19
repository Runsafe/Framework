package no.runsafe.framework.api.item.data;

import no.runsafe.framework.minecraft.data.TreeSpecies;

public interface IWoodenStepData extends IItemData
{
	TreeSpecies getSpecies();
	boolean isInverted();
	void setInverted(boolean inverted);
	void setSpecies(TreeSpecies species);
}
