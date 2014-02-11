package no.runsafe.framework.api.event.inventory;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.inventory.RunsafePrepareItemCraftEvent;

public interface IPrepareCraftItem extends IRunsafeEvent
{
	void OnPrepareCraftItem(RunsafePrepareItemCraftEvent event);
}
