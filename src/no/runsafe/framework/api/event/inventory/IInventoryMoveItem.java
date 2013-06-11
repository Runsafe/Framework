package no.runsafe.framework.api.event.inventory;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryMoveItemEvent;

public interface IInventoryMoveItem extends IRunsafeEvent
{
	void OnInventoryMoveItemEvent(RunsafeInventoryMoveItemEvent event);
}
