package no.runsafe.framework.event.inventory;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.inventory.RunsafeInventoryPickupItemEvent;

public interface IInventoryPickupItem extends IRunsafeEvent
{
	public void OnInventoryPickupItemEvent(RunsafeInventoryPickupItemEvent event);
}
