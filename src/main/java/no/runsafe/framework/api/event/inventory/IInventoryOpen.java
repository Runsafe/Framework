package no.runsafe.framework.api.event.inventory;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;

public interface IInventoryOpen extends IRunsafeEvent
{
	boolean OnInventoryOpen(IPlayer player, RunsafeInventory inventory);
}
