package no.runsafe.framework.api.block;

import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.minecraft.RunsafeLocation;

public interface IDoubleChest extends IInventoryHolder
{
	IInventoryHolder getLeftSide();
	RunsafeLocation getLocation();
	IInventoryHolder getRightSide();
}
