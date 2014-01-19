package no.runsafe.framework.api.item.data;

import no.runsafe.framework.minecraft.data.TreeSpecies;

public interface ILeavesData extends IItemData
{
	TreeSpecies getSpecies();
	void setSpecies(TreeSpecies species);
}
