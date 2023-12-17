package no.runsafe.framework.api.block;

import no.runsafe.framework.api.minecraft.IInventoryHolder;

public interface IDropper extends IInventoryHolder, IBlockState, IBlock
{
	void drop();
}
