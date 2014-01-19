package no.runsafe.framework.api.item.data;

import no.runsafe.framework.minecraft.data.GrassSpecies;

public interface ILongGrassData extends IItemData
{
	GrassSpecies getSpecies();
	void setSpecies(GrassSpecies species);
}
