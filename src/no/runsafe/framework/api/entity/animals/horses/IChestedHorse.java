package no.runsafe.framework.api.entity.animals.horses;

import no.runsafe.framework.api.minecraft.IInventoryHolder;

public interface IChestedHorse extends IAbstractHorse, IInventoryHolder
{
	boolean isCarryingChest();

	void setCarryingChest(boolean chest);
}
