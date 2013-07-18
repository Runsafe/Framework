package no.runsafe.framework.api.event.inventory;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryPickupItemEvent;

public interface IInventoryPickupItem extends IRunsafeEvent
{
	void OnInventoryPickupItemEvent(RunsafeInventoryPickupItemEvent event);
}
