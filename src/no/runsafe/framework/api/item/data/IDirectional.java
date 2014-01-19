package no.runsafe.framework.api.item.data;

import no.runsafe.framework.minecraft.data.BlockFace;

public interface IDirectional
{
	BlockFace getFacing();
	void setFacingDirection(BlockFace face);
}
