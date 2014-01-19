package no.runsafe.framework.api.item.data;

import no.runsafe.framework.minecraft.data.CocoaPlantSize;

public interface ICocoaPlantData extends IItemData, IAttachable
{
	CocoaPlantSize getSize();
	void setSize(CocoaPlantSize size);
}
