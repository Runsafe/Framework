package no.runsafe.framework.event.inventory;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.inventory.RunsafeInventoryMoveItemEvent;

public interface IInventoryMoveItem extends IRunsafeEvent
{
	void OnInventoryMoveItemEvent(RunsafeInventoryMoveItemEvent event);
}
