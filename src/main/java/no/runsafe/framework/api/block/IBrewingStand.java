package no.runsafe.framework.api.block;

import no.runsafe.framework.minecraft.inventory.RunsafeInventory;

public interface IBrewingStand extends IBlockState, IBlock
{
	int getBrewingTime();
	void setBrewingTime(int i);
	RunsafeInventory getInventory();
}
