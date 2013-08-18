package no.runsafe.framework.api.event.inventory;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.inventory.RunsafeCraftItemEvent;

public interface ICraftItem extends IRunsafeEvent
{
	void OnCraftItem(RunsafeCraftItemEvent event);
}
