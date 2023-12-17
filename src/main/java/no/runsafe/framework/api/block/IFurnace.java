package no.runsafe.framework.api.block;

import no.runsafe.framework.api.minecraft.IInventoryHolder;

public interface IFurnace extends IBlockState, IInventoryHolder, IBlock
{
	short getBurnTime();
	void setBurnTime(short time);
	short getCookTime();
	void setCookTime(short time);
}
