package no.runsafe.framework.api.item.data;

import no.runsafe.framework.minecraft.data.SandstoneType;

public interface ISandstoneData extends IItemData
{
	SandstoneType getType();
	void setType(SandstoneType type);
}
