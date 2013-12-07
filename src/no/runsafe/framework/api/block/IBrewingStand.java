package no.runsafe.framework.api.block;

import no.runsafe.framework.api.block.IBlockState;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;

public interface IBrewingStand extends IBlockState
{
	int getBrewingTime();
	void setBrewingTime(int i);
	RunsafeInventory getInventory();
}
