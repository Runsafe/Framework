package no.runsafe.framework.api.event.inventory;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.inventory.RunsafeInventoryClickEvent;

public interface IInventoryClick extends IRunsafeEvent
{
	void OnInventoryClickEvent(RunsafeInventoryClickEvent event);
}
