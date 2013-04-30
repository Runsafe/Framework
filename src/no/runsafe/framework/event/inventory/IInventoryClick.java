package no.runsafe.framework.event.inventory;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.inventory.RunsafeInventoryClickEvent;

public interface IInventoryClick extends IRunsafeEvent
{
	public void OnInventoryClickEvent(RunsafeInventoryClickEvent event);
}
