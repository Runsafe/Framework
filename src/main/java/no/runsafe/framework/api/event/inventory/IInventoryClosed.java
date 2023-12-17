package no.runsafe.framework.api.event.inventory;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryCloseEvent;

public interface IInventoryClosed extends IRunsafeEvent
{
	void OnInventoryClosed(RunsafeInventoryCloseEvent event);
}
