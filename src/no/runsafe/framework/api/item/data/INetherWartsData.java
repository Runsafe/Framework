package no.runsafe.framework.api.item.data;

import no.runsafe.framework.minecraft.data.NetherWartsState;

public interface INetherWartsData extends IItemData
{
	NetherWartsState getState();
	void setState(NetherWartsState state);
}
