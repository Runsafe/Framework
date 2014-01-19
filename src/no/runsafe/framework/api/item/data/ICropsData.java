package no.runsafe.framework.api.item.data;

import no.runsafe.framework.minecraft.data.CropState;

public interface ICropsData extends IItemData
{
	CropState getState();
	void setState(CropState state);
}
