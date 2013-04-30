package no.runsafe.framework.event.inventory;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.inventory.RunsafeInventoryEvent;

public interface IInventory extends IRunsafeEvent
{
	public void OnInventoryEvent(RunsafeInventoryEvent event);
}
