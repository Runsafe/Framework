package no.runsafe.framework.api.item.data;

import no.runsafe.framework.minecraft.data.CoalType;

public interface ICoalData extends IItemData
{
	CoalType getType();
	void setType(CoalType type);
}
