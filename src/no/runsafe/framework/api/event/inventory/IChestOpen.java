package no.runsafe.framework.api.event.inventory;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public interface IChestOpen extends IRunsafeEvent
{
	boolean OnChestOpen(RunsafePlayer player, RunsafeInventory inventory);
}
