package no.runsafe.framework.api.block;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.minecraft.IInventoryHolder;

public interface IDoubleChest extends IInventoryHolder
{
	IInventoryHolder getLeftSide();
	ILocation getLocation();
	IInventoryHolder getRightSide();
}
