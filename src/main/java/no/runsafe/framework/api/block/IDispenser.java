package no.runsafe.framework.api.block;

import no.runsafe.framework.api.minecraft.IInventoryHolder;

public interface IDispenser extends IInventoryHolder, IBlockState, IBlock
{
	boolean dispense();
}
