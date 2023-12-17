package no.runsafe.framework.api.event.inventory;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryEvent;

public interface IInventory extends IRunsafeEvent
{
	void OnInventoryEvent(RunsafeInventoryEvent event);
}
