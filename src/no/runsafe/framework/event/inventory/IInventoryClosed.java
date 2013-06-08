package no.runsafe.framework.event.inventory;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.inventory.RunsafeInventoryCloseEvent;

public interface IInventoryClosed extends IRunsafeEvent
{
	void OnInventoryClosed(RunsafeInventoryCloseEvent event);
}
