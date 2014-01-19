package no.runsafe.framework.api.item.data;

import no.runsafe.framework.minecraft.data.BlockFace;

public interface IStairsData extends IItemData, IDirectional
{
	BlockFace getAscendingDirection();
	BlockFace getDescendingDirection();
	boolean isInverted();
	void setInverted(boolean inverted);
}
