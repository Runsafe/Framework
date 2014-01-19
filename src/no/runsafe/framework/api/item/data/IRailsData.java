package no.runsafe.framework.api.item.data;

import no.runsafe.framework.minecraft.data.BlockFace;

public interface IRailsData extends IItemData
{
	BlockFace getDirection();
	boolean isCurve();
	boolean isOnSlope();
	void setDirection(BlockFace face, boolean isOnSlope);
}
